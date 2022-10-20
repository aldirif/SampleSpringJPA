package com.rapidtech.springdatajpapgsql.controller;

import com.rapidtech.springdatajpapgsql.dto.BookCategoryReqDto;
import com.rapidtech.springdatajpapgsql.dto.BookCategoryResDto;
import com.rapidtech.springdatajpapgsql.service.BookCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/bookcategory")
@RestController
public class BookCategoryController {

    @Autowired
    private BookCategoryService bookCategoryService;

    @GetMapping
    public List<BookCategoryResDto> getAll(){
        return bookCategoryService.getAll();
    }

    @GetMapping("/{id}")
    public BookCategoryResDto getById(@PathVariable("id") Long id){
        return bookCategoryService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookCategoryResDto post(@RequestBody BookCategoryReqDto bookCategory){
        return bookCategoryService.insertBookCategory(bookCategory);
    }

    @PutMapping("{id}")
    public BookCategoryResDto put(@PathVariable("id") Long id,@RequestBody BookCategoryReqDto bookCategory){
        return bookCategoryService.updateBookCategory(id,bookCategory);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id){
        bookCategoryService.deleteBookCategory(id);
        return "Data id "+id.toString()+" berhasil dihapus";
    }
}