package com.rapidtech.springdatajpapgsql.repository;

import com.rapidtech.springdatajpapgsql.model.Book;
import com.rapidtech.springdatajpapgsql.model.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {
    List<Book> findAllByWriter(String writer);
    List<Book> findAllByBookCategory(BookCategory bookCat);
    List<Book> findAllByWriterContaining(String writer);
    Book findByIsbn(String isbn);
    List<Book> findAllByIsbnContaining(String isbn);
    @Query(nativeQuery = true,value = "select * from book order by title")
    List<Book> findAllQueryNative();
    @Query(nativeQuery = true,value = "select * from book where writer = ?1")
    List<Book> findAllByWriterNative(String writer);
}