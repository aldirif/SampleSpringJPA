package com.rapidtech.springdatajpapgsql.controller;

import com.rapidtech.springdatajpapgsql.dto.StudentReqDto;
import com.rapidtech.springdatajpapgsql.dto.StudentResDto;
import com.rapidtech.springdatajpapgsql.model.Student;
import com.rapidtech.springdatajpapgsql.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/students")
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<StudentResDto> getAllStudent(){
        return studentService.getAllStudent();
    }

    @GetMapping("/{id}")
    public StudentResDto getbyid(@PathVariable("id") Long id) {
        return studentService.getStudentById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentResDto insertstudent(@RequestBody StudentReqDto studentReqDto){
        return studentService.insertStudent(studentReqDto);

    }
    @PutMapping("/{id}")
    public Student put(@PathVariable("id") Long id, @RequestBody StudentReqDto studentReqDto) {
        return studentService.updateStudent(id, studentReqDto);
    }
    public String deleteStudent(@PathVariable("id") Long id){
        studentService.deleteStudent(id);
        return "Delete student id: "+id.toString()+" berhasil";
    }
}