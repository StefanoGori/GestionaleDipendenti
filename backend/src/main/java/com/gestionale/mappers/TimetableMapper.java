package com.gestionale.mappers;

import com.gestionale.entities.Timetable;

import org.mapstruct.Mapper;

import com.gestionale.dto.TimetableDto;

@Mapper
public interface TimetableMapper {
	TimetableDto timetableToTimetableDto(Timetable timetable);
	Timetable timetableDtoToTimetable(TimetableDto timetableDto);
}
