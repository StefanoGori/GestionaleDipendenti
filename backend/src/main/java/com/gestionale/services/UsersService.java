package com.gestionale.services;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import com.gestionale.dto.UserDto;
import com.gestionale.entities.User;
import com.gestionale.mapper.UserMapper;
import com.gestionale.repositories.UsersRepository;


@Service
public class UsersService {
	
	private final UsersRepository usersRepository;
	//private final UserMapper userMapper;
	
	public UsersService (UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
		//this.userMapper = userMapper;
	}
	
	// CRUD Operation
	
	// Read All
	@Transactional(readOnly=true)
    public List<User> findUsers() {
        return usersRepository.findAll();    
    }
	
	// Read one by id
	@Transactional(readOnly=true)
	public Optional<User> findUserById(String cf) throws Exception{
		if(usersRepository.existsById(cf)) {
			return usersRepository.findById(cf);
		}
		String msg= "The user does not exist";
		throw new Exception(msg);
	}
	
	// create
	
	@Transactional
	public String createUser(User user) throws Exception{
		if(usersRepository.existsById(user.getCf())) {
			String msg= "User already exists";
			throw new Exception(msg);	
		} 
		int lengthCf = user.getCf().length();
		if(lengthCf != 16) {
			String msg= "User's cf is not valid";
			throw new Exception(msg);
		}
		usersRepository.save(user);
		String msg= "User created successfully";
		return msg;
	}
	
	// delete
	@Transactional
	public String deleteUser(String cf) throws Exception{
		if(!usersRepository.existsById(cf)) {
			String msg= "The user does not exist";
			throw new Exception(msg);
		} 
		usersRepository.deleteById(cf);
		String msg="User deleted successfully";
		return msg;
	}
	
	// update 
	
	@Transactional
	public String updateUser(User user) throws Exception {
		if(!usersRepository.existsById(user.getCf())) {
			String msg= "annot edit a user that does not exist";
			throw new Exception(msg);	
		} else {
			String msg= "User update successfully";
			usersRepository.save(user);
			return msg;
		}
	}
	
	
	

}
