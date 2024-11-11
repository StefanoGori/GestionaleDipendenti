package com.gestionale.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionale.entities.User;
import com.gestionale.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository ur;

    public Iterable<User> findAll() {
        return ur.findAll();
    }

    @Transactional
    public String addUser(User u) throws Exception{
        String msg="User added";
        if(ur.existsById(u.getCF())) {
            msg="User already exists";
            throw new Exception(msg);
        }else {
            ur.save(u);
            return msg;
        }
    }

    @Transactional
    public String deleteUser(String cf) throws Exception{

        if (ur.existsById(cf)) {
            ur.deleteById(cf);
            return "User deleted";
        } else {
            throw new Exception("User not found with cf: "+cf);
            
        }

    }

    @Transactional
    public String updateUser(User u) throws Exception{
        String msg="User updated";
        if(ur.existsById(u.getCF())) {
            ur.save(u);
            return msg;
        }else {
            msg="User not found";
            throw new Exception(msg);
        }
    }

}
