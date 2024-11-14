package com.gestionale.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.gestionale.dto.UserDto;
import com.gestionale.entities.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
	
	@Mapping(target = "timetables", source = "timetables")
	UserDto userToUserDto(User user);
	User userDtotoUser(UserDto userDto);
	

    /*default GrantedAuthority toGrantedAuthority(Role role) {
        return new SimpleGrantedAuthority(role.getCode());
    }*/
}
