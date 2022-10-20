package com.rapidtech.springdatajpapgsql.service;

import com.rapidtech.springdatajpapgsql.dto.BookCategoryReqDto;
import com.rapidtech.springdatajpapgsql.dto.BookCategoryResDto;

import java.util.List;

public interface BookCategoryService {
    List<BookCategoryResDto> getAll();
    BookCategoryResDto getById(Long id);
    BookCategoryResDto insertBookCategory(BookCategoryReqDto bookCategory);
    BookCategoryResDto updateBookCategory(Long id,BookCategoryReqDto bookCategory);
    void deleteBookCategory(Long id);
}