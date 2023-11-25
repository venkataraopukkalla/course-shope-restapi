package com.vikkey.allsocialservices.courseshoping.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import com.vikkey.allsocialservices.courseshoping.entity.CourseEntity;
import com.vikkey.allsocialservices.courseshoping.repository.CourseRepository;

@Service
public class CourseService {
	
	//private String resourcePath="\\Users\\vikra\\OneDrive\\Pictures\\Project@Freelancer\\CourseShoppingRestAPI";
	
	private CourseRepository courseRepository;

	public CourseService(CourseRepository courseRepository) {
		super();
		this.courseRepository = courseRepository;
	}
	
//	// image 
//	
//	public String uploadToFileSystem(MultipartFile file) {
//		
//		 String fileName = file.getOriginalFilename();
//        String filePath = Paths.get(resourcePath, fileName).toString();
//       
//		return filePath;
//	}
//	
//	public byte[] downloadImagefromFileSystem(String fileName) throws IOException {
//			
//			Optional<CourseEntity> entOptional=courseRepository.findByImageName(fileName);
//			String imagePath = entOptional.get().getCourseImageResources();
//			byte[] allBytes = Files.readAllBytes(new File(imagePath).toPath());
//			
//			return allBytes;
//			
//		}
//
//	
	//get all Courses
	public List<CourseEntity> getAllCourses(){
		return courseRepository.findAll();
	}
	
	// get specific course
	public CourseEntity getCourseById( Long id) {
		return courseRepository.getById(id)	;
	}
	
	//post the course i.e enter the course details
	public CourseEntity addCourseDetails( CourseEntity courseEntity) {
	
		return courseRepository.save(courseEntity);
	}
	
	
	//delete the course
	public void deleteCourseById(Long id) {
		courseRepository.deleteById(id);
	}
	
	//update the course details
	
	public CourseEntity updateCourseEntity(Long id,CourseEntity courseEntity) {
		CourseEntity oldEntity = courseRepository.findById(id).orElseThrow();
		oldEntity.setCourseTitle(courseEntity.getCourseTitle());
	
		oldEntity.setCoursePrice(courseEntity.getCoursePrice());
		oldEntity.setDiscountPercentage(courseEntity.getDiscountPercentage());
		oldEntity.setCourseDesc(courseEntity.getCourseDesc());
		
		return courseRepository.save(oldEntity);
	}
	
	
}
