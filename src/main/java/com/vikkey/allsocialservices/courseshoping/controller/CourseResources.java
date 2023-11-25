package com.vikkey.allsocialservices.courseshoping.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.vikkey.allsocialservices.courseshoping.entity.CourseEntity;
import com.vikkey.allsocialservices.courseshoping.services.CourseService;

@RestController
public class CourseResources {
	private CourseService courseService;

	public CourseResources(CourseService courseService) {
		super();
		this.courseService = courseService;
	}
	
	//get --- display all course details
	@GetMapping("/courses")
	public List<CourseEntity> getAllCoursesDetails() {
		return courseService.getAllCourses();
		
	}
	// get{id}-- display specific course detail
	@GetMapping("/courses/{id}")
	public CourseEntity getSpecificCourseDetail(@PathVariable Long id) {
		return courseService.getCourseById(id);
	}
	
	// post -- add new course
	@PostMapping("courses/addcourse")
	public ResponseEntity<?> addNewCourse(@RequestBody CourseEntity entity) {
		CourseEntity addCourseDetails = courseService.addCourseDetails(entity);
		if(addCourseDetails!=null ) {
			return ResponseEntity.status(HttpStatus.OK)
                    .contentType(MediaType.TEXT_PLAIN)
                    .body("Sucessfull add new course details");
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Failed to adding new courses");

	}
	
	//delete specific 
	
	@DeleteMapping("/courses/delete/{id}")
	public void deleteCourseById (@PathVariable Long id) {
		courseService.deleteCourseById(id);
	}
}
