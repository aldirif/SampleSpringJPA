package com.rapidtech.springdatajpapgsql.service.impl;

import com.rapidtech.springdatajpapgsql.dto.BookCategoryReqDto;
import com.rapidtech.springdatajpapgsql.dto.BookCategoryResDto;
import com.rapidtech.springdatajpapgsql.model.BookCategory;
import com.rapidtech.springdatajpapgsql.repository.BookCategoryRepository;
import com.rapidtech.springdatajpapgsql.service.BookCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookCategoryServiceImpl implements BookCategoryService {
    @Autowired
    private BookCategoryRepository bookCategoryRepository;

    @Override
    public List<BookCategoryResDto> getAll() {
        List<BookCategory> bookCategories = bookCategoryRepository.findAll();
        List<BookCategoryResDto> bookCategoriesDto =
                bookCategories.stream().map(this::mapToProductResponse).toList();
        return bookCategoriesDto;
    }

    private BookCategoryResDto mapToProductResponse(BookCategory bookCategory) {
        return BookCategoryResDto.builder()
                .id(bookCategory.getId())
                .name(bookCategory.getName())
                .build();
    }

    @Override
    public BookCategoryResDto getById(Long id) {
        BookCategory bookCategory = bookCategoryRepository.findById(id).get();
        BookCategoryResDto bookCategoryResDto = mapToProductResponse(bookCategory);
        return bookCategoryResDto;
    }

    @Override
    public BookCategoryResDto insertBookCategory(BookCategoryReqDto bookCategoryDto) {
        BookCategory bookCategory = new BookCategory();
        bookCategory.setName(bookCategoryDto.getName());
        BookCategory result = bookCategoryRepository.save(bookCategory);

        BookCategoryResDto bookCatRes = new BookCategoryResDto();
        bookCatRes.setId(result.getId());
        bookCatRes.setName(result.getName());

        return bookCatRes;
    }

    @Override
    public BookCategoryResDto updateBookCategory(Long id,BookCategoryReqDto bookCategoryDto) {
        BookCategory bookCategory = bookCategoryRepository.findById(id).get();
        BookCategory bookCatEdit = new BookCategory();
        bookCatEdit.setId(bookCategory.getId());
        bookCatEdit.setName(bookCategoryDto.getName());

        BookCategory result = bookCategoryRepository.save(bookCatEdit);

        BookCategoryResDto bookCatRes = new BookCategoryResDto();
        bookCatRes.setId(result.getId());
        bookCatRes.setName(result.getName());

        return bookCatRes;
    }

    @Override
    public void deleteBookCategory(Long id) {
        BookCategory delBook = bookCategoryRepository.findById(id).orElse(new BookCategory());
        bookCategoryRepository.delete(delBook);
    }
}