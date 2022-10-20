package com.rapidtech.springdatajpapgsql.service.impl;

import com.rapidtech.springdatajpapgsql.dto.StudentReqDto;
import com.rapidtech.springdatajpapgsql.dto.StudentResDto;
import com.rapidtech.springdatajpapgsql.model.Student;
import com.rapidtech.springdatajpapgsql.repository.StudentRepository;
import com.rapidtech.springdatajpapgsql.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<StudentResDto> getAllStudent() {
        List<Student> students = studentRepository.findAll();
        List<StudentResDto> studentResDtoList = new ArrayList<>();
        for(Student student : students){
            studentResDtoList.add(StudentResDto.builder()
                    .id(student.getId()).name(student.getName()).age(student.getAge()).build());
        }
        return studentResDtoList;
    }

    @Override
    public StudentResDto getStudentById(Long id) {
        StudentResDto studentResDto = new StudentResDto();
        Student student = studentRepository.findById(id).orElse(new Student());
        studentResDto.setId(student.getId());
        studentResDto.setName(student.getName());
        studentResDto.setAge(student.getAge());

        return studentResDto;
    }

    @Override
    public StudentResDto insertStudent(StudentReqDto studentReqDto) {
        Student newStudent = Student.builder().name(studentReqDto.getName())
                .age(studentReqDto.getAge()).build();
        Student result = studentRepository.save(newStudent);
        return StudentResDto.builder().id(result.getId()).name(result.getName())
                .age(result.getAge()).build();
    }

    @Override
    public Student updateStudent(Long id, StudentReqDto studentReqDto) {
        Optional<Student> updateStudent = studentRepository.findById(id);
        Student result = new Student();
        if (updateStudent.isPresent()){
            Student student = updateStudent.get();
            student.setName(studentReqDto.getName());
            student.setAge(studentReqDto.getAge());
            result = studentRepository.save(student);
        }
        return Student.builder().id(result.getId())
                .name(result.getName()).age(result.getAge()).build();
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}