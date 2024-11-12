package com.gestionale.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestionale.entities.Hours;

public interface HoursRepository extends JpaRepository<Hours, String>{
    
}
