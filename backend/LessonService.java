package org.example.springdatajpa.service;

import java.util.List;

import javax.transaction.Transactional;

import org.example.springdatajpa.domain.Lesson;
import org.example.springdatajpa.repository.CourseRepository;
import org.example.springdatajpa.repository.LessonRepository;
import org.example.springdatajpa.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LessonService {

	@Autowired
	private LessonRepository lessonRepo;
	
	@Autowired
	private TeacherRepository teacherRepo;
	
	@Autowired 
	private CourseRepository courseRepo;
	
	
	
	// Create
	
		@Transactional
		public String createLesson (Lesson l) throws Exception {
			if(lessonRepo.existsById(l.getId())) {
				String msg = "Existing lesson";
				throw new Exception(msg);
			} else if (!teacherRepo.existsById(l.getTeacher().getId())) {
					String msg = "The Teacher of this lesson doesn't exist";
					throw new Exception(msg);
			} else if(!courseRepo.existsById(l.getCourse().getId())) {
						String msg = "The Course of this lesson doesn't exist";
						throw new Exception(msg);
			} else {
				lessonRepo.save(l);
				String msg="Lesson inserted with success";
				return msg;
	        }
	    }
		
		// Read
		
		public List<Lesson> readAllLesson(){
			return lessonRepo.findAll();
		}
		
		// Update
		
		@Transactional
		public String updateLesson(Lesson l) throws Exception{
			if(!lessonRepo.existsById(l.getId())) {
				String msg= "The lesson doesn't exists";
				throw new Exception(msg);
			} else if (!teacherRepo.existsById(l.getTeacher().getId())) {
				String msg = "The Teacher of this lesson doesn't exist";
				throw new Exception(msg);
			} else if(!courseRepo.existsById(l.getCourse().getId())) {
					String msg = "The Course of this lesson doesn't exist";
					throw new Exception(msg);
			} else {
				String msg= "Lesson update";
				lessonRepo.save(l);
				return msg;
			}
		}
		
		// Delete
		
		public String deleteLesson(long id) throws Exception {
			if(lessonRepo.existsById(id)) {
				lessonRepo.deleteById(id);
				String msg = "Lesson Eliminated";
				return msg;
			} else {
				String msg= "The lesson doesn't exist.";
				throw new Exception(msg);
			}
		}
}
