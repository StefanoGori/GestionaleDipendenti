package com.gestionale.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gestionale.entities.User;

public interface UsersRepository extends JpaRepository<User, String> {
	
	@Query(value="select * from users u where cf= :cf", nativeQuery=true)
	Optional<User> findByCf(@Param("cf")String cf);
	
	
	@Query(value="select u.cf from users u where name= :nameInput and surname= :surnameInput", nativeQuery=true)
	String findByNameAndSurname(@Param("nameInput") String name, @Param("surnameInput") String surname);

}
