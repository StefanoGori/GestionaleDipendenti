package com.gestionale.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

import com.gestionale.dto.GenericResponseDto;
// import com.gestionale.dto.UserDto;
import com.gestionale.entities.User;
import com.gestionale.services.UsersService;

@RestController
@RequestMapping("management/employees")
//@CrossOrigin(origins="*", allowedHeaders = "*")
public class UsersController {

	private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("all")
    public List<User> getUsers() {
    	return usersService.findUsers();
    }
    
    @GetMapping("{cf}")
    public ResponseEntity<?> getUserById(@PathVariable("cf") String cf) throws Exception {
    	try {
    		Optional<User> user = usersService.findUserById(cf);
    		return new ResponseEntity<>(user, HttpStatus.OK);
    	} catch (Exception e){
    		return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);    	
    	} 
    }
    
    @PostMapping(path="add", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto> createUser(@RequestBody User user) throws Exception {
    	try {
    		String msg = usersService.createUser(user);
    		return ResponseEntity.ok(new GenericResponseDto(msg)); 		
    	} catch (Exception e){
    		return new ResponseEntity<GenericResponseDto>(new GenericResponseDto(e.getMessage()), HttpStatus.CONFLICT); 
    	} 
    }
    
    @PutMapping("edit")
    public ResponseEntity<String> editUser(@RequestBody User user) throws Exception{
    	try {
    		String msg = usersService.updateUser(user);
    		return new ResponseEntity<>(msg, HttpStatus.OK);    	
    		} catch (Exception e){
    			return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT); 
    		}
    }
    
    @DeleteMapping(path= "delete/{cf}", produces= MediaType.TEXT_PLAIN_VALUE)
    public  ResponseEntity<String> deleteUser(@PathVariable String cf) throws Exception{
    	try {
    		String msg = usersService.deleteUser(cf);
    		return new ResponseEntity<>(msg, HttpStatus.OK);    		
    	} catch (Exception e){
			return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT); 
    	}
    }
    
	
}
