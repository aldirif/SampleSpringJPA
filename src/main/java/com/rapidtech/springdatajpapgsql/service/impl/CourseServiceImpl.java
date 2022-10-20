package com.rapidtech.springdatajpapgsql.service.impl;

import com.rapidtech.springdatajpapgsql.dto.*;
import com.rapidtech.springdatajpapgsql.model.Course;
import com.rapidtech.springdatajpapgsql.model.Student;
import com.rapidtech.springdatajpapgsql.repository.CourseRepository;
import com.rapidtech.springdatajpapgsql.repository.StudentRepository;
import com.rapidtech.springdatajpapgsql.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<CourseResDto> getAllCourse() {
        List<Course> courses = courseRepository.findAll();
        List<CourseResDto> courseResDtoList = new ArrayList<>();
        for(Course course : courses){
            courseResDtoList.add(CourseResDto.builder()
                    .id(course.getId()).title(course.getTitle()).modules(course.getModules()).fee(course.getFee()).build());
        }
        return courseResDtoList;
    }

    @Override
    public CourseResDto getCourseById(Long id) {
        CourseResDto courseResDto = new CourseResDto();
        Course course = courseRepository.findById(id).orElse(new Course());
       courseResDto.setId(course.getId());
       courseResDto.setTitle(course.getTitle());
       courseResDto.setModules(course.getModules());
       courseResDto.setFee(course.getFee());

       return courseResDto;
    }

    @Override
    public CourseResDto insertCourse(CourseReqDto courseReqDto) {
        Course newCourse = Course.builder().title(courseReqDto.getTitle())
                .modules(courseReqDto.getModules()).fee(courseReqDto.getFee()).build();
        Course result = courseRepository.save((newCourse));
        return CourseResDto.builder().id(result.getId()).title(result.getTitle())
                .modules(result.getModules()).fee(result.getFee()).build();
    }

    @Override
    public Course updateCourse(Long id, CourseReqDto courseReqDto) {
        Optional<Course> updateCourse = courseRepository.findById(id);
        Course result = new Course();
        if (updateCourse.isPresent()){
            Course course = updateCourse.get();
            course.setTitle(courseReqDto.getTitle());
            course.setModules(courseReqDto.getModules());
            course.setFee(courseReqDto.getFee());
            result = courseRepository.save(course);
        }
        return Course.builder().id(result.getId())
                .title(result.getTitle()).modules(result.getModules()).fee(result.getFee()).build();
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public void registerStudentToCourse(CourseWithStudentDto courseWithStudentDto) {
        Course course = courseRepository.findById(courseWithStudentDto.getCourseId()).get();
        Student student = studentRepository.findById(courseWithStudentDto.getStudentId()).get();

        student.getCourses().add(course);
        studentRepository.save(student);
    }

    @Override
    public CourseWithStudentResDto getCourseWithStudentById(Long id) {
        Course course = courseRepository.findById(id).get();
        List<Student> studentList = course.getStudents();
        List<StudentResDto> studentResDtoList = new ArrayList<>();
        for (Student student : studentList){
            studentResDtoList.add(StudentResDto.builder()
                    .id(student.getId())
                    .name(student.getName())
                    .age(student.getAge())
                    .build());
        }
        return CourseWithStudentResDto.builder()
                .id(course.getId())
                .title(course.getTitle())
                .modules(course.getModules())
                .fee(course.getFee())
                .studentResDtoList(studentResDtoList)
                .build();
    }

    @Override
    public List<CourseWithStudentResDto> getAllCourseWithStudent() {
        List<Course> courses = courseRepository.findAll();
        List<CourseWithStudentResDto> courseWithStudentResDtoList = new ArrayList<>();
        for(Course course : courses){
            List<StudentResDto> studentResDtoList = new ArrayList<>();
            for(Student student : course.getStudents()){
                studentResDtoList.add(StudentResDto.builder()
                        .id(student.getId()).name(student.getName())
                        .age(student.getAge()).build());
            }
            courseWithStudentResDtoList.add(
                    CourseWithStudentResDto.builder()
                            .id(course.getId())
                            .title(course.getTitle())
                            .modules(course.getModules())
                            .fee(course.getFee())
                            .studentResDtoList(studentResDtoList)
                            .build()
            );
        }
        return courseWithStudentResDtoList;
    }
}
