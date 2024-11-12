package com.gestionale.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestionale.entities.Attendance;
import com.gestionale.services.AttendanceService;
import org.springframework.web.bind.annotation.PutMapping;


@RestController

@RequestMapping("/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService As;

    @GetMapping(value = "/test", produces = "application/json")
    public ResponseEntity<String> test() {
        return new ResponseEntity<>("Attendance controller works", HttpStatus.OK);
    }

    @GetMapping(value = "/all", produces = "application/json")
    public ResponseEntity<List<Attendance>> allAttendance(){
        List<Attendance> a= (List<Attendance>) As.findAll();
        return new ResponseEntity<List<Attendance>>(a, HttpStatus.OK);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<String> addAttendance(@RequestBody Attendance a){
        try {
            return new ResponseEntity<String>(As.addAttendance(a), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }   
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteAttendance(@PathVariable("id") Long id){
        try {
            return new ResponseEntity<String>(As.deleteAttendance(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/update")
    public ResponseEntity<String> updateAttendance(@RequestBody Attendance a){
        try {
            return new ResponseEntity<String>(As.updateAttendance(a), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
