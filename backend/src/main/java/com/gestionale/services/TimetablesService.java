package com.gestionale.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gestionale.entities.Timetable;
import com.gestionale.entities.User;
import com.gestionale.repositories.TimetablesRepository;
import com.gestionale.repositories.UsersRepository;


@Service
public class TimetablesService {
	
	private final TimetablesRepository timeRepository;
	private final UsersRepository userRepository;
	
	public TimetablesService (TimetablesRepository timeRepository, UsersRepository userRepository){
		this.timeRepository = timeRepository;	
		this.userRepository = userRepository;
	}
	
	// CRUD Operation
	
		// Read All
		@Transactional(readOnly=true)
	    public List<Timetable> findTimetables() {
	        return timeRepository.findAll();    
	    }
		
		// Read one by id
		@Transactional(readOnly=true)
		public Optional<Timetable> findTimetableById(Long id) throws Exception{
			if(timeRepository.existsById(id)) {
				return timeRepository.findById(id);
			}
			String msg= "The user does not exist";
			throw new Exception(msg);
		}
		
		//Read all of user 
		@Transactional
		public List<Timetable> findTimetableByUser(String name, String surname) throws Exception{
			String cf = userRepository.findByNameAndSurname(name, surname);
			System.out.println(cf);
			if(!userRepository.existsById(cf)) {
				String msg= "User not exist";
				throw new Exception(msg);
			}
			List<Timetable> ListSchedules = timeRepository.getAllTimeTableByUser(cf).get();
			if(ListSchedules.isEmpty()) {
				String msg= "The user has no timetable";
				throw new Exception(msg);
			}
			return ListSchedules;
		}
		
	// create
		
	@Transactional
	public String createTimeForUser(Timetable time, String cf) throws Exception{
		
		Optional<User> user = userRepository.findById(cf);
		if(!user.isPresent()) {
			String msg= "User not exist";
			throw new Exception(msg);
		} else if(timeRepository.existsById(time.getId())) {
			String msg= "The timetable with this id alredy exist";
			throw new Exception(msg);
		} else {
			if(timeRepository.existByDayAndUserId(time.getDay(), cf)==1) {
				String msg= "The user has alredy a timetable for this day";
				throw new Exception(msg);
			} else {
				time.setUser(user.get());
				timeRepository.save(time);
				String msg = "Timetable assigned";
				return msg;
			}	
		}
	}
	
	//delete
	@Transactional
	public String deleteTimeTable(Long id) throws Exception {
		if(!timeRepository.existsById(id)) {
			String msg= "The timetable not exist";
			throw new Exception(msg);
		}
		timeRepository.deleteById(id);
		String msg= "The timetable deleted successfully";
		return msg;
	}
	
	//update
	
	@Transactional
	public String updateTimetable(Timetable time) throws Exception{
		if(!timeRepository.existsById(time.getId())) {
			String msg= "The timetable not exist";
			throw new Exception(msg);
		} else {
			String cf = timeRepository.findById(time.getId()).get().getUser().getCf();
			System.out.println(cf);	
			if(timeRepository.existByDayAndUserIdAndIdTimetable(time.getDay(), cf , time.getId())==1) {
				String msg= "The user has alredy a timetable for this day";
				throw new Exception(msg);	
			}
			timeRepository.save(time);
			String msg= "Timetable update successfully";
			return msg;
		}
	}
}

