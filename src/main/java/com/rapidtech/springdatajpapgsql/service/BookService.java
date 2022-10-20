package com.rapidtech.springdatajpapgsql.service;

import com.rapidtech.springdatajpapgsql.dto.BookReqDto;
import com.rapidtech.springdatajpapgsql.dto.BookResDto;
import com.rapidtech.springdatajpapgsql.dto.BookWithCategoryDto;

import java.util.List;

public interface BookService {
    List<BookResDto> getAllBook();
    List<BookWithCategoryDto> getAllBookWithCat();
    BookResDto getBookById(Long id);
    BookResDto insertBook(BookReqDto book);
    BookResDto updateBook(Long id,BookReqDto book);
    void deleteBook(Long id);
}