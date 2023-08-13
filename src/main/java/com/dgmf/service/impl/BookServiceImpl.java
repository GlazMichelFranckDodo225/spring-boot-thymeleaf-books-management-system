package com.dgmf.service.impl;

import com.dgmf.entity.Book;
import com.dgmf.repository.BookRepository;
import com.dgmf.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Override
    public List<Book> findAllBooks() {
        List<Book> allBooks = (List<Book>) bookRepository.findAll();

        return allBooks;
    }

    @Override
    public Book findBookById(Long id) {
        Optional<Book> foundBook = bookRepository.findById(id);

        if(foundBook.isPresent()) {
            return foundBook.get();
        }

        return null;
    }

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Book book) {
        Optional<Book> foundBook = bookRepository.findById(book.getId());

        if(foundBook.isPresent()) {
            Book retrievalBook = foundBook.get();
            retrievalBook.setName(book.getName());
            retrievalBook.setAuthor(book.getAuthor());
            retrievalBook.setNumberOfPages(book.getNumberOfPages());
            retrievalBook.setPublication(book.getPublication());

            return bookRepository.save(retrievalBook);
        }

        return null;
    }

    @Override
    public void deleteBookById(Long id) {
        Book book = findBookById(id);

        if(book != null) {
            bookRepository.delete(book);
        }
    }
}
