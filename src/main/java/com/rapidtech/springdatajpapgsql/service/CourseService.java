package com.rapidtech.springdatajpapgsql.service;

import com.rapidtech.springdatajpapgsql.dto.CourseReqDto;
import com.rapidtech.springdatajpapgsql.dto.CourseResDto;
import com.rapidtech.springdatajpapgsql.dto.CourseWithStudentDto;
import com.rapidtech.springdatajpapgsql.dto.CourseWithStudentResDto;
import com.rapidtech.springdatajpapgsql.model.Course;

import java.util.List;

public interface CourseService {
    List<CourseResDto> getAllCourse();
    CourseResDto getCourseById(Long id);
    CourseResDto insertCourse(CourseReqDto courseReqDto);
    Course updateCourse(Long id, CourseReqDto courseReqDto);
    void deleteCourse(Long id);
    void registerStudentToCourse(CourseWithStudentDto courseWithStudentDto);
    CourseWithStudentResDto getCourseWithStudentById(Long id);
    List <CourseWithStudentResDto> getAllCourseWithStudent();
}
