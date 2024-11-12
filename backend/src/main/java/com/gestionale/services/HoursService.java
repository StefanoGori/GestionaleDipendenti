package com.gestionale.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionale.entities.Hours;
import com.gestionale.repositories.HoursRepository;

import jakarta.transaction.Transactional;

@Service
public class HoursService {
    
    @Autowired
    private HoursRepository Hr;

    public Iterable<Hours> findAll() {
        return Hr.findAll();
    }

    @Transactional
    public String addHours(Hours h) throws Exception{
        String msg="Hours added";
        if(Hr.existsById(h.getId())) {
            msg="Hours already exists";
            throw new Exception(msg);
        }else {
            Hr.save(h);
            return msg;
        }
    }

    @Transactional
    public String deleteHours(String id) throws Exception{

        if (Hr.existsById(id)) {
            Hr.deleteById(id);
            return "Hours deleted";
        } else {
            throw new Exception("Hours not found with id: "+id);
            
        }

    }

    @Transactional
    public String updateHours(Hours h) throws Exception{
        String msg="Hours updated";
        if(Hr.existsById(h.getId())) {
            Hr.save(h);
            return msg;
        }else {
            msg="Hours not found";
            throw new Exception(msg);
        }
    }
}