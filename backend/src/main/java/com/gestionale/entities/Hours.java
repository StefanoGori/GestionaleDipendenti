package com.gestionale.entities;

import java.sql.Time;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="hours")
public class Hours {
	
	@Id
	@Column(name="ID",nullable = false, length=100, unique = true)
	private String 	ID;
	
	@Column(name="Entrance", nullable=false)
	private Time Entrance;
	
	@Column(name="Exit", nullable=false)
	private Time Exit;
	
	@Column (name="Date", nullable=false)
	private Date Date;

// ------------------------------------GETTER AND SETTER------------------------------------

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public Time getEntrance() {
		return Entrance;
	}

	public void setEntrance(Time entrance) {
		Entrance = entrance;
	}

	public Time getExit() {
		return Exit;
	}

	public void setExit(Time exit) {
		Exit = exit;
	}

	public Date getDate() {
		return Date;
	}

	public void setDate(Date date) {
		Date = date;
	}
}
