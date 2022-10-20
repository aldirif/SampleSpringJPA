package com.rapidtech.springdatajpapgsql.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseWithStudentDto {
    private Long studentId;
    private Long courseId;
}