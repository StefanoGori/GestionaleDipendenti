package com.gestionale.entities;

import java.time.LocalTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="hours")
@JsonIgnoreProperties({"Attendance"})
public class Hours {
	
	@Id
	@Column(name="id",nullable = false, length=100, unique = true)
	private String 	id;

	@OneToMany(mappedBy = "hours")
	@JsonManagedReference(value="hours-attendance")
	private List<Attendance> attendance;
	
	@Column(name="entrance")
	private LocalTime entrance;
	
	@Column(name="leaving")
	private LocalTime leaving;
	
	@Column(name="day", nullable = false)
	private LocalDate day;

	

// ------------------------------------GETTER AND SETTER------------------------------------

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Attendance> getAttendance() {
		return this.attendance;
	}

	public void setAttendance(List<Attendance> attendance) {
		this.attendance = attendance;
	}

	public LocalTime getEntrance() {
		return this.entrance;
	}

	public void setEntrance(LocalTime entrance) {
		this.entrance = entrance;
	}

	public LocalTime getLeaving() {
		return this.leaving;
	}

	public void setLeaving(LocalTime leaving) {
		this.leaving = leaving;
	}

	public LocalDate getDay() {
		return this.day;
	}

	public void setDay(LocalDate day) {
		this.day = day;
	}

	
}
