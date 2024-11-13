package com.gestionale.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestionale.entities.User;

public interface UsersRepository extends JpaRepository<User, String> {

}
