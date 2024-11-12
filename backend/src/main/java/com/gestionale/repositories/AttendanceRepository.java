package com.gestionale.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.gestionale.entities.Attendance;
@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long>{
    
}
