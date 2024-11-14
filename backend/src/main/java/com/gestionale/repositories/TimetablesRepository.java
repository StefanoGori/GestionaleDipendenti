package com.gestionale.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gestionale.entities.Timetable;





public interface TimetablesRepository extends JpaRepository<Timetable, Long> {

	@Query(value="select t.* from timetable t inner join users u on (t.user_id=u.cf) where cf= :cf", nativeQuery=true)
	Optional<List<Timetable>> getAllTimeTableByUser( @Param("cf") String cf); 
	
	@Query(value="select exists (select 1 from timetable where day= :dayInput and user_id= :idInput)", nativeQuery=true)
	int existByDayAndUserId(@Param("dayInput") LocalDate day, @Param("idInput") String cf); 
	
	@Query(value="select exists (select 1 from timetable where day= :dayInput and user_id= :idInput and id!= :idRicevuto)", nativeQuery=true)
	int existByDayAndUserIdAndIdTimetable(@Param("dayInput") LocalDate day, @Param("idInput") String cf, @Param("idRicevuto") Long id ); 
}


