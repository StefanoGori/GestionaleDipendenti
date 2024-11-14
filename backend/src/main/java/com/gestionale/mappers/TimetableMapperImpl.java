package com.gestionale.mappers;

import com.gestionale.dto.TimetableDto;
import com.gestionale.entities.Timetable;
import com.gestionale.mappers.TimetableMapper;

import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-14T11:06:17+0100",
    comments = "version: 1.6.2, compiler: Eclipse JDT (IDE) 3.39.0.v20240820-0604, environment: Java 21.0.4 (Eclipse Adoptium)"
)
public class TimetableMapperImpl implements TimetableMapper {

    @Override
    public TimetableDto timetableToTimetableDto(Timetable timetable) {
        if ( timetable == null ) {
            return null;
        }

        TimetableDto timetableDto = new TimetableDto();

        timetableDto.setId( timetable.getId() );
        timetableDto.setUser( timetable.getUser() );
        timetableDto.setDay( timetable.getDay() );
        timetableDto.setEntrance( timetable.getEntrance() );
        timetableDto.setLeaving( timetable.getLeaving() );
        timetableDto.setStamped_in( timetable.getStamped_in() );
        timetableDto.setStamped_out( timetable.getStamped_out() );
        timetableDto.setHoliday( timetable.getHoliday() );
        timetableDto.setUsedpermits( timetable.getUsedpermits() );

        return timetableDto;
    }

    @Override
    public Timetable timetableDtoToTimetable(TimetableDto timetableDto) {
        if ( timetableDto == null ) {
            return null;
        }

        Timetable timetable = new Timetable();

        timetable.setId( timetableDto.getId() );
        timetable.setDay( timetableDto.getDay() );
        timetable.setEntrance( timetableDto.getEntrance() );
        timetable.setLeaving( timetableDto.getLeaving() );
        timetable.setStamped_in( timetableDto.getStamped_in() );
        timetable.setStamped_out( timetableDto.getStamped_out() );
        timetable.setHoliday( timetableDto.getHoliday() );
        timetable.setUsedpermits( timetableDto.getUsedpermits() );
        timetable.setUser( timetableDto.getUser() );

        return timetable;
    }
}
