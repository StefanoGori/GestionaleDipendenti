package com.gestionale.entities;

import java.time.LocalTime;


import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="hours")
public class Hours {
	
	@Id
	@Column(name="ID",nullable = false, length=100, unique = true)
	private String 	ID;

	@OneToOne(mappedBy = "Hours")
	private Attendance Attendance;
	
	@Column(name="Entrance")
	private LocalTime Entrance;
	
	@Column(name="Leaving")
	private LocalTime Leaving;
	
	@Column(name="day", nullable = false)
	private LocalDate Day;

// ------------------------------------GETTER AND SETTER------------------------------------

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public LocalTime getEntrance() {
		return Entrance;
	}

	public void setEntrance(LocalTime entrance) {
		Entrance = entrance != null ? entrance : LocalTime.of(9, 0);
	}

	public LocalTime getLeaving() {
		return Leaving;
	}

	public void setLeaving(LocalTime leaving) {
		Leaving = leaving != null ? leaving : LocalTime.of(18, 0);
	}

	public LocalDate getDay() {
		return Day;
	}

	public void setDay(LocalDate day) {
		Day = day;
	}

	public Attendance getAttendance() {
        return Attendance;
    }

    public void setAttendance(Attendance attendance) {
        this.Attendance = attendance;
    }
}
