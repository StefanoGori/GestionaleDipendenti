package com.gestionale.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class User {
	
	
	// creazione della chiave primaria CF con lunghezza 16, unica e not nullable
	@Id
	@Column(name="CF", nullable=false, length = 16, unique=true)
	private String CF;

	@OneToOne(mappedBy = "User")
	private Attendance Attendance;
	
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

	@Column (name="pwd")
	private String pwd;

		// creazione get e setter
	public String getCF() {
		return CF;
	}

	public void setCF(String cF) {
		CF = cF;
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

	public Attendance getAttendance() {
        return Attendance;
    }

    public void setAttendance(Attendance attendance) {
        this.Attendance = attendance;
    }
	
	

	
	
	
	
	
	
	
	
	
	

}
