package com.gestionale.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.gestionale.entities.Timetable;

//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//public class UserDto implements UserDetails{

public class UserDto implements UserDetails{

	private String cf;
	
	private String name;
	
	private String surname;
	
	private String password;
	
	private Boolean admin;
	
	private int daysoff;
	
	private int permits;
	
	private List<Timetable> timetables;

	// metodi richiesti da UserDetails
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities= new ArrayList<>();
		if(admin) {
			authorities.add(new SimpleGrantedAuthority("ADMIN"));
		} else { 
			authorities.add(new SimpleGrantedAuthority("USER"));
		}
		return authorities;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return cf;
	}
	
	// getter e setter 
	
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

	public List<Timetable> getTimetables() {
		return timetables;
	}

	public void setTimetables(List<Timetable> timetables) {
		this.timetables = timetables;
	}

	
}
