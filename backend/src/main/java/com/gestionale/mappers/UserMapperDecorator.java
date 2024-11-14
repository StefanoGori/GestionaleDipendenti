package com.gestionale.mappers;

import org.mapstruct.Qualifier;
import org.springframework.beans.factory.annotation.Autowired;

import com.gestionale.dto.UserDto;
import com.gestionale.entities.User;
import com.gestionale.repositories.TimetablesRepository;

public abstract class UserMapperDecorator implements UserMapper {
	
	@Autowired
	private UserMapper delegate;
    
	
	@Autowired
	private TimetablesRepository timeRepository;

	
	@Override
	public User toUser (UserDto userDto) {
		User user = delegate.toUser(userDto);
		user.setTimetables(timeRepository.findAllById(userDto.getTimetablesId()));
		return user;
	}
}
