package com.rapidtech.springdatajpapgsql.repository;

import com.rapidtech.springdatajpapgsql.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {

}