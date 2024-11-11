package com.gestionale.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionale.entities.Attendance;
import com.gestionale.entities.AttendanceKey;
import com.gestionale.repositories.AttendanceRepository;

import jakarta.transaction.Transactional;

@Service
public class AttendanceService {
    
    @Autowired
    private AttendanceRepository ar;

    public Iterable<Attendance> findAll() {
        return ar.findAll();
    }

    @Transactional
    public String addAttendance(Attendance a) throws Exception{
        String msg="Attendance added";
        if(ar.existsById(a.getId())) {
            msg="Attendance already exists";
            throw new Exception(msg);
        }else {
            ar.save(a);
            return msg;
        }
    }

    @Transactional
    public String deleteAttendance(AttendanceKey id) throws Exception{

        if (ar.existsById(id)) {
            ar.deleteById(id);
            return "Attendance deleted";
        } else {
            throw new Exception("Attendance not found with id: "+id);
            
        }

    }

    @Transactional
    public String updateAttendance(Attendance a) throws Exception{
        String msg="Attendance updated";
        if(ar.existsById(a.getId())) {
            ar.save(a);
            return msg;
        }else {
            msg="Attendance not found";
            throw new Exception(msg);
        }
    }
}
