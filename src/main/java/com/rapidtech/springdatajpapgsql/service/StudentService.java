package com.rapidtech.springdatajpapgsql.service;

import com.rapidtech.springdatajpapgsql.dto.StudentReqDto;
import com.rapidtech.springdatajpapgsql.dto.StudentResDto;
import com.rapidtech.springdatajpapgsql.model.Student;

import java.util.List;

public interface StudentService {
    List<StudentResDto> getAllStudent();
    StudentResDto getStudentById(Long id);
    StudentResDto insertStudent(StudentReqDto studentReqDto);
    Student updateStudent(Long id, StudentReqDto studentReqDto);
    void deleteStudent(Long id);
}