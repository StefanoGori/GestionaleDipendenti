package com.gestionale.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.gestionale.entities.User;

public class TimetableDto {
	

	private Long id;
	
    private User user;
	
	private LocalDate day;
	

	private LocalTime entrance;
	
	
	private LocalTime leaving;


	private LocalTime stamped_in;
	
	
	private LocalTime stamped_out;
	

	private Boolean holiday;
	
	
	private Integer usedpermits;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
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
	
	
	

}
