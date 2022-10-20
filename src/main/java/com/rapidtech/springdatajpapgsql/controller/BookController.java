package com.rapidtech.springdatajpapgsql.controller;

import com.rapidtech.springdatajpapgsql.dto.BookReqDto;
import com.rapidtech.springdatajpapgsql.dto.BookResDto;
import com.rapidtech.springdatajpapgsql.dto.BookWithCategoryDto;
import com.rapidtech.springdatajpapgsql.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/book")
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<BookResDto> get(){
        return bookService.getAllBook();
    }

    @GetMapping("/withcategory")
    public List<BookWithCategoryDto> getBookWithCategory(){
        return bookService.getAllBookWithCat();
    }

    @GetMapping("/{id}")
    public BookResDto getbyid(@PathVariable("id") Long id)
    {
        return bookService.getBookById(id);
    }

    @PostMapping
    public BookResDto post(@RequestBody BookReqDto book){
        return bookService.insertBook(book);
    }

    @PutMapping("/{id}")
    public BookResDto put(@PathVariable("id") Long id, @RequestBody BookReqDto book){
        return bookService.updateBook(id,book);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id){
        bookService.deleteBook(id);
        return "Data id:"+ id.toString() +" berhasil di delete";
    }
}