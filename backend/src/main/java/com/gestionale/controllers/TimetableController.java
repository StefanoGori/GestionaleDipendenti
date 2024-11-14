package com.gestionale.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestionale.entities.Timetable;
import com.gestionale.services.TimetablesService;

@RestController
@RequestMapping("management/timetables")
@CrossOrigin(origins="*", allowedHeaders = "*")
public class TimetableController {
	
	private final TimetablesService timeService;
	
	public TimetableController(TimetablesService timeService) {
		this.timeService = timeService;
	}
	
	@GetMapping("all")
    public ResponseEntity<List<Timetable>> readTimetables() {
    	List<Timetable> listTimetable=timeService.findTimetables();
    	return new ResponseEntity<>(listTimetable, HttpStatus.OK);
    }
	
	@GetMapping("{id}")
    public ResponseEntity<?> readTimetablesById(@PathVariable("id") Long id) {
    	try{
    		Optional<Timetable> time = timeService.findTimetableById(id);
    		return new ResponseEntity<>(time, HttpStatus.OK);
    	} catch (Exception e){
    		return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);    	
    	} 
	}
	
	@GetMapping("/readof/{name}/{surname}")
    public ResponseEntity<?> readTimetablesByUser(@PathVariable("name") String n,@PathVariable("surname") String s ) {
    	try{
    		List<Timetable> ListTime = timeService.findTimetableByUser(n,s);
    		return new ResponseEntity<>(ListTime, HttpStatus.OK);
    	} catch (Exception e){
    		return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);    	
    	} 
	}
	
	
	
	@PostMapping("add/{cf}")
	public ResponseEntity<String> createTimetableForUser(@RequestBody Timetable time, @PathVariable("cf")String cf){
		try {
    		String msg = timeService.createTimeForUser(time, cf);
    		return new ResponseEntity<>(msg, HttpStatus.OK);	
    	} catch (Exception e){
    		return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT); 
    	} 
	}
	
	// modifica ma bisogna mandargli tutto l'user
	@PutMapping("edit")
	public ResponseEntity<String> editTimetable(@RequestBody Timetable time) throws Exception{
		try {
			String msg= timeService.updateTimetable(time);
			return new ResponseEntity<>(msg, HttpStatus.OK);	
		} catch (Exception e){
    		return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT); 
    	}
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteTimetable(@PathVariable("id") Long id){
		try {
			String msg= timeService.deleteTimeTable(id);
    		return new ResponseEntity<>(msg, HttpStatus.OK);		
		} catch (Exception e){
			return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT); 
    	} 
	}
	
	
	
	

}
