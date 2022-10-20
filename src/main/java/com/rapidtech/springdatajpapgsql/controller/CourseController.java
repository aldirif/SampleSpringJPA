package com.rapidtech.springdatajpapgsql.controller;

import com.rapidtech.springdatajpapgsql.dto.CourseReqDto;
import com.rapidtech.springdatajpapgsql.dto.CourseResDto;
import com.rapidtech.springdatajpapgsql.dto.CourseWithStudentDto;
import com.rapidtech.springdatajpapgsql.dto.CourseWithStudentResDto;
import com.rapidtech.springdatajpapgsql.model.Course;
import com.rapidtech.springdatajpapgsql.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/courses")
@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<CourseResDto> getAllCourse() {
        return courseService.getAllCourse();
    }

    @GetMapping("/{id}")
    public CourseResDto getbyid(@PathVariable("id") Long id) {
        return courseService.getCourseById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CourseResDto insertcourse(@RequestBody CourseReqDto courseReqDto) {
        return courseService.insertCourse(courseReqDto);
    }
    @PutMapping("/{id}")
    public Course put(@PathVariable("id") Long id, @RequestBody CourseReqDto courseReqDto) {
        return courseService.updateCourse(id, courseReqDto);
    }

    public String deleteCourse(@PathVariable("id") Long id){
        courseService.deleteCourse(id);
        return "Delete course id: "+id.toString()+" berhasil";
    }
    @PostMapping("/student")
    public String registerStudentToCourse(@RequestBody CourseWithStudentDto courseWithStudentDto) {
        courseService.registerStudentToCourse(courseWithStudentDto);
        return "Berhasil menambahkan student " + courseWithStudentDto.getStudentId().toString() +
                " ke course " + courseWithStudentDto.getCourseId().toString();
    }
    @GetMapping("/{id}/student")
    public CourseWithStudentResDto getCourseWithStudentById(@PathVariable("id") Long id){
        return courseService.getCourseWithStudentById(id);
    }
    @GetMapping("/withstudents")
    public List<CourseWithStudentResDto> getAllCourseWithStudent(){
        return courseService.getAllCourseWithStudent();
    }
}
