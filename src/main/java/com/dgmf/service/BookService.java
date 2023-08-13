package com.dgmf.service;

import com.dgmf.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAllBooks();
    Book findBookById(Long id);
    Book addBook(Book book);
    Book updateBook(Book book);
    void deleteBookById(Long id);
}
