package com.gestionale.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestionale.services.HoursService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.gestionale.entities.Hours;



@RestController

@RequestMapping("/hours")
public class HoursController {
    
    @Autowired
    private HoursService Hs;

    @GetMapping(value = "/test", produces = "application/json")
    public ResponseEntity<String> test() {
        return new ResponseEntity<>("Hours controller works", HttpStatus.OK);
    }

    @GetMapping(value = "/all", produces = "application/json")
    public ResponseEntity<List<Hours>> allHours(){
        List<Hours> h= (List<Hours>) Hs.findAll();
        return new ResponseEntity<List<Hours>>(h, HttpStatus.OK);
    }

    @PostMapping(value = "/add", consumes = "application/json")
    public ResponseEntity<String> addHours(@RequestBody Hours h){
        try {
            return new ResponseEntity<String>(Hs.addHours(h), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }   
    }

    @DeleteMapping(value = "/delete", produces = "application/json")
    public ResponseEntity<String> deleteHours(@RequestParam String id){
        try {
            return new ResponseEntity<String>(Hs.deleteHours(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/update")
    public ResponseEntity<?> updateHours(@RequestBody Hours h){
        try {
            return new ResponseEntity<String>(Hs.updateHours(h), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    

}
