package com.gestionale.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name="timetable", uniqueConstraints = {
		@UniqueConstraint(columnNames = {"user_id", "day"})
})
public class Timetable {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
	
	@Column(name="day", nullable = false)
	private LocalDate day;
	
	@Column(name="entrance", nullable = false)
	private LocalTime entrance;
	
	@Column(name="leaving", nullable = false)
	private LocalTime leaving;

	@Column(name="stamped_in")
	private LocalTime stamped_in;
	
	@Column(name="stamped_out")
	private LocalTime stamped_out;
	
	@Column(name="holiday")
	private Boolean holiday;
	
	@Column(name="usedpermits")
	private Integer usedpermits;


	// Getter and Setters
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDay() {
		return day;
	}

	public void setDay(LocalDate day) {
		this.day = day;
	}

	public LocalTime getEntrance() {
		return entrance;
	}

	public void setEntrance(LocalTime entrance) {
		this.entrance = entrance;
	}

	public LocalTime getLeaving() {
		return leaving;
	}

	public void setLeaving(LocalTime leaving) {
		this.leaving = leaving;
	}

	public LocalTime getStamped_in() {
		return stamped_in;
	}

	public void setStamped_in(LocalTime stamped_in) {
		this.stamped_in = stamped_in;
	}

	public LocalTime getStamped_out() {
		return stamped_out;
	}

	public void setStamped_out(LocalTime stamped_out) {
		this.stamped_out = stamped_out;
	}

	public Boolean getHoliday() {
		return holiday;
	}

	public void setHoliday(Boolean holiday) {
		this.holiday = holiday;
	}

	public Integer getUsedpermits() {
		return usedpermits;
	}

	public void setUsedpermits(Integer usedpermits) {
		this.usedpermits = usedpermits;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
