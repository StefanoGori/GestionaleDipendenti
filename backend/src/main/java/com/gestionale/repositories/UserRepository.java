package com.gestionale.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestionale.entities.User;

public interface UserRepository extends JpaRepository<User, String> {

}
