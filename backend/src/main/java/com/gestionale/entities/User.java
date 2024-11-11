package com.gestionale.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Users")
public class User {
	
	@Id
	@Column(name="CF", nullable=false, length = 16, unique=true)
	private String CF;
	
	@Column(name="Name", nullable=false)
	private String name;
	
	@Column(name="Surname", nullable=false)
	private String surname;
	
	@Column(name="Email", nullable=false, unique=true)
	private String email;
	
	@Column(name="Admin")
	private Boolean Admin;
	
	
	
	
	

}
