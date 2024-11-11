package com.gestionale.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestionale.entities.User;
import com.gestionale.services.UserService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



@RestController

@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService us;

    @GetMapping(value = "/test", produces = "application/json")
    public ResponseEntity<String> test() {
        return new ResponseEntity<>("Users controller works", HttpStatus.OK);
    }

    @GetMapping(value = "/all", produces = "application/json")
    public ResponseEntity<List<User>> allUsers(){
        List<User> u= (List<User>) us.findAll();
        return new ResponseEntity<List<User>>(u, HttpStatus.OK);
    }

    @PostMapping(value = "/add", produces = "application/json")
    public ResponseEntity<String> addUser(@RequestBody User u){
        try {
            return new ResponseEntity<String>(us.addUser(u), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }   
    }

    @DeleteMapping(value = "/delete", produces = "application/json")
    public ResponseEntity<String> deleteUser(@RequestParam String cf){
        try {
            return new ResponseEntity<String>(us.deleteUser(cf), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/update")
    public ResponseEntity<?> updateUser(@RequestBody User u){
        try {
            return new ResponseEntity<String>(us.updateUser(u), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    
}
