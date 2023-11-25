package com.vikkey.allsocialservices.courseshoping.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vikkey.allsocialservices.courseshoping.entity.CourseEntity;

public interface CourseRepository extends JpaRepository< CourseEntity,Long>{

}
