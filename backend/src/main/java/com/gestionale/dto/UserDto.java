package com.gestionale.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;



public class UserDto implements UserDetails{

	private String username;
	
	private String name;
	
	private String surname;
	
	private String password;
	
	private int daysoff;
	
	private int permits;
	
	private List<Long> timetablesId;
	
	List<GrantedAuthority> authorities = new ArrayList<>();

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public List<Long> getTimetablesId() {
		return timetablesId;
	}

	public void setTimetablesId(List<Long> timetablesId) {
		this.timetablesId = timetablesId;
	}

	public List<GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}	
}
