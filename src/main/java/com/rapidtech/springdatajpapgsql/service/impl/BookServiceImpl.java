package com.rapidtech.springdatajpapgsql.service.impl;

import com.rapidtech.springdatajpapgsql.dto.BookCategoryResDto;
import com.rapidtech.springdatajpapgsql.dto.BookReqDto;
import com.rapidtech.springdatajpapgsql.dto.BookResDto;
import com.rapidtech.springdatajpapgsql.dto.BookWithCategoryDto;
import com.rapidtech.springdatajpapgsql.model.Book;
import com.rapidtech.springdatajpapgsql.model.BookCategory;
import com.rapidtech.springdatajpapgsql.repository.BookRepository;
import com.rapidtech.springdatajpapgsql.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<BookResDto> getAllBook() {
        List<BookResDto> booksDto = new ArrayList<>();
        List<Book> books = bookRepository.findAll();
        for(Book book : books){
            booksDto.add(new BookResDto(book.getId(),book.getTitle(),book.getWriter(),
                    book.getIsbn()));
        }
        return booksDto;
    }

    @Override
    public List<BookWithCategoryDto> getAllBookWithCat() {
        List<BookWithCategoryDto> bookWithCategoryDtoList = new ArrayList<>();
        List<Book> books = bookRepository.findAll();
        for(Book book : books){
            bookWithCategoryDtoList.add(BookWithCategoryDto.builder()
                    .id(book.getId()).title(book.getTitle())
                    .writer(book.getWriter()).isbn(book.getIsbn())
                    .bookCategoryResDto(
                            BookCategoryResDto.builder()
                                    .id(book.getBookCategory().getId())
                                    .name(book.getBookCategory().getName()).build()).build());
        }
        return bookWithCategoryDtoList;
    }

    @Override
    public BookResDto getBookById(Long id) {
        BookResDto bookResDto = new BookResDto();
        Book book = bookRepository.findById(id).orElse(new Book());
        bookResDto.setId(book.getId());
        bookResDto.setTitle(book.getTitle());
        bookResDto.setWriter(book.getWriter());
        bookResDto.setIsbn(book.getIsbn());

        return bookResDto;
    }

    @Override
    public BookResDto insertBook(BookReqDto bookReqDto) {
        Book newBook = new Book();
        newBook.setTitle(bookReqDto.getTitle());
        newBook.setWriter(bookReqDto.getWriter());
        newBook.setIsbn(bookReqDto.getIsbn());
        newBook.setBookCategory(
                BookCategory.builder().id(bookReqDto.getCategoryId()).build());
        Book result = bookRepository.save(newBook);
        return BookResDto.builder().id(result.getId())
                .title(result.getTitle()).writer(result.getWriter())
                .isbn(result.getIsbn()).build();
    }

    @Override
    public BookResDto updateBook(Long id,BookReqDto bookReqDto) {
        Book editBook = Book.builder().id(id).title(bookReqDto.getTitle())
                .writer(bookReqDto.getWriter()).isbn(bookReqDto.getIsbn())
                .bookCategory(BookCategory.builder().id(bookReqDto.getCategoryId()).build())
                .build();
        Book result = bookRepository.save(editBook);
        return BookResDto.builder().id(result.getId()).writer(result.getWriter())
                .title(result.getTitle()).isbn(result.getIsbn()).build();
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}