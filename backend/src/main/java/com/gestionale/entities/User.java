package com.gestionale.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
@JsonIgnoreProperties({"Attendance"})

public class User {
	
	
	// creazione della chiave primaria CF con lunghezza 16, unica e not nullable
	@Id
	@Column(name="cf", nullable=false, length = 16, unique=true)
	private String cf;

	@OneToMany(mappedBy = "user")
	@JsonManagedReference(value="user-attendance")
	private List<Attendance> attendance;
	
	//campo nome not nullable
	@Column(name="name", nullable=false)
	private String name;
	
	//campo cognome not nullable
	@Column(name="surname", nullable=false)
	private String surname;
	
	//campo email not nullable e unico
	@Column(name="email", nullable=false, unique=true)
	private String email;
	
	//campo admin default false
	@Column(name="Admin",  columnDefinition = "boolean default false")
	private Boolean admin;
	
	@Column(name="Holidays")
	private int holidays;
	
	@Column(name="Permissions")
	private int permission;

	@Column(name="pwd")
	private String pwd;

		// creazione get e setter
	public String getCF() {
		return cf;
	}

	public void setCF(String cF) {
		cf = cF;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	public int getHolidays() {
		return holidays;
	}

	public void setHolidays(int holidays) {
		this.holidays = holidays;
	}

	public int getPermission() {
		return permission;
	}

	public void setPermission(int permission) {
		this.permission = permission;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public List<Attendance> getAttendance() {
        return attendance;
    }

    public void setAttendance(List<Attendance> attendance) {
        this.attendance = attendance;
    }
	
	

	
	
	
	
	
	
	
	
	
	

}
