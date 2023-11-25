package com.vikkey.allsocialservices.courseshoping.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CourseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String courseTitle;
	private String coursePrice;
	private String discountPercentage; 
	private String courseDesc;
	
	public CourseEntity() {
		// TODO Auto-generated constructor stub
	}
	
	public CourseEntity(String courseTitle, String coursePrice, String discountPercentage, String courseDesc) {
		super();
		this.courseTitle = courseTitle;
		this.coursePrice = coursePrice;
		this.discountPercentage = discountPercentage;
		this.courseDesc = courseDesc;
		
		
	}
	
	public long getId() {
		return id;
	}
	public String getCourseTitle() {
		return courseTitle;
	}
	public String getCoursePrice() {
		return coursePrice;
	}
	public String getDiscountPercentage() {
		return discountPercentage;
	}
	public String getCourseDesc() {
		return courseDesc;
	}
	

	
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public void setCoursePrice(String coursePrice) {
		this.coursePrice = coursePrice;
	}

	public void setDiscountPercentage(String discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	public void setCourseDesc(String courseDesc) {
		this.courseDesc = courseDesc;
	}

	
	
	

}


