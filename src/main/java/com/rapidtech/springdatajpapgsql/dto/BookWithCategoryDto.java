package com.rapidtech.springdatajpapgsql.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookWithCategoryDto {
        private Long id;
        private String title;
        private String writer;
        private String isbn;
        private BookCategoryResDto bookCategoryResDto;
}