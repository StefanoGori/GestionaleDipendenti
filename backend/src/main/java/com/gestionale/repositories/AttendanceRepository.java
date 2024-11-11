package com.gestionale.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestionale.entities.Attendance;
import com.gestionale.entities.AttendanceKey;

public interface AttendanceRepository extends JpaRepository<Attendance, AttendanceKey>{

    @Override
    default boolean existsById(AttendanceKey id) {
        return existsById(id);
    }
    
}
