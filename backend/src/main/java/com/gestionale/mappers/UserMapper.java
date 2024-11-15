 package com.gestionale.mappers;


 import java.util.ArrayList;
 import java.util.List;
 import java.util.stream.Collectors;

 import org.mapstruct.DecoratedWith;
 import org.mapstruct.Mapper;
 import org.mapstruct.Mapping;
 import org.mapstruct.Named;
 import org.mapstruct.factory.Mappers;
 import org.springframework.security.core.GrantedAuthority;
 import org.springframework.security.core.authority.SimpleGrantedAuthority;

 import com.gestionale.dto.UserDto;
 import com.gestionale.entities.Timetable;
 import com.gestionale.entities.User;

 @Mapper(componentModel = "spring")
 @DecoratedWith(UserMapperDecorator.class)
 public interface UserMapper {

 	 UserMapper delegate = Mappers.getMapper( UserMapper.class );
	
 	@Mapping(target="username", source="cf")
 	@Mapping(target="authorities", source="admin", qualifiedByName ="adminToAuthority")
 	UserDto toUserDto(User user);
	
	
	
 	@Mapping(target="cf", source="username")
 	@Mapping(target = "admin", source="userDto.authorities", qualifiedByName = "authorityToAdmin")
 	User toUser(UserDto userDto); // <- si usa per passare la repository per convertire l'array di id timetable
	
	
 	// mappiamo la relazione tra admin boolean e l'array di grantedAuthority con un espressione complessa per User a UserDto
 	@Named("adminToAuthority")
 	default List<GrantedAuthority> adminToAuthority(Boolean admin){
 		List<GrantedAuthority> authorities= new ArrayList<>();
 		if(admin) {
 			authorities.add(new SimpleGrantedAuthority("ADMIN"));
 		} else { 
 			authorities.add(new SimpleGrantedAuthority("USER"));
 		}
 		return authorities;
 	}
	
 	// facciamo il contrario da UserDto a User
 	@Named("authorityToAdmin")
 	default boolean authorityToAdmin(List<GrantedAuthority> authorities) {
 		for(GrantedAuthority authority : authorities) {
 			if ("ADMIN".equals(authority.getAuthority())) {
 	            return true;
 			} 
 		}
 		return false;
 	}
	
 	// ritorno una lista di id di timetable associati all'user nello UserDto (user)->userMapper.toUserDto(user)
 	@Named("listTimetableId")
	default List<Long> timetablesIdOfUserDto(List<Timetable> timetables){
 		/* trasformo la lista di timetable in uno stream
 		 * trasformo ogni elemento dello stream in un nuovo elemento formato solo dall'id di ogni timetable
 		 * raccolgo tutti gli id contenuti nello stream in una lista di Long
 		 */
 		return timetables.stream().map(Timetable::getId).collect(Collectors.toList());
 	}
	
 	/* ritorno una lista ti timetables ripresi dalla lista id dallo UserDto allo User -> metodo poi passato nel mapperDecorator
 	con la classe mapper non è possibile fare l'autowired se non passandola come parametro nel metodo toUser, quindi si passa anche come parametro per il metodo di trasformazione 
 	@Named("listTimetables")
 	default List<Timetable> timetablesOfUser(List<Long> timetablesId, TimetablesRepository timeRepository){
 		return timeRepository.findAllById(timetablesId);
 	}*/

 }
