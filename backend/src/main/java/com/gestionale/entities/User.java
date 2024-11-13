package com.gestionale.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="users")

public class User {
	
	
	// creazione della chiave primaria CF con lunghezza 16, unica e not nullable
	@Id
	@Column(name="cf", nullable=false, length = 16)
	private String cf;

	//campo nome not nullable
	@Column(name="name", nullable=false, length = 100)
	private String name;
	
	//campo cognome not nullable
	@Column(name="surname", nullable=false, length = 100)
	private String surname;
	
	//campo password not nullable
	@Column(name="password", nullable=false)
	private String password;
	
	//campo admin default false
	@Column(name="admin",  columnDefinition = "boolean default false")
	private Boolean admin;
	
	@Column(name="daysoff", columnDefinition = "int default 0" )
	private int daysoff;
	
	@Column(name="permits", columnDefinition = "int default 0")
	private int permits;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Timetable> timetables = new ArrayList<>();
	
	
	// creazione getters e setters

	public String getCf() {
		return cf;
	}

	public void setCf(String cf) {
		this.cf = cf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	public int getDaysoff() {
		return daysoff;
	}

	public void setDaysoff(int daysoff) {
		this.daysoff = daysoff;
	}

	public int getPermits() {
		return permits;
	}

	public void setPermits(int permits) {
		this.permits = permits;
		
	}
	
}
