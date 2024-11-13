package com.gestionale.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gestionale.entities.User;

public interface UsersRepository extends JpaRepository<User, String> {
	
	@Query(value="select u.cf from users u where name= :nameInput and surname= :surnameInput", nativeQuery=true)
	String findByNameAndSurname(@Param("nameInput") String name, @Param("surnameInput") String surname);

}
