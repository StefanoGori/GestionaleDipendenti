package com.gestionale.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionale.entities.Attendance;
import com.gestionale.repositories.AttendanceRepository;

import org.springframework.transaction.annotation.Transactional;

@Service
public class AttendanceService {


    @Autowired
    private AttendanceRepository ar;

    @Transactional(readOnly = true)
    public Iterable<Attendance> findAll() {
        return ar.findAll();
    }

    @Transactional
    public String addAttendance(Attendance a) throws Exception{
        String msg="Attendance added";
        if(ar.existsById(a.getIdA())) {
            msg="Attendance already exists";
            throw new Exception(msg);
        }else {
            ar.save(a);
            return msg;
        }
    }

    @Transactional
    public String deleteAttendance(Long id) throws Exception{
        String msg="Attendance deleted";
        if(ar.existsById(id)) {
            ar.deleteById(id);
            return msg;
        }else {
            msg="Attendance not found";
            throw new Exception(msg);
        }

    }

    @Transactional
    public String updateAttendance(Attendance a) throws Exception{
        String msg="Attendance updated";
        if(ar.existsById(a.getIdA())) {
            ar.save(a);
            return msg;
        }else {
            msg="Attendance not found";
            throw new Exception(msg);
        }
    }
}
