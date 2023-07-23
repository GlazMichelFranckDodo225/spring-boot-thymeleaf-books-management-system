package com.dgmf.service.impl;

import com.dgmf.repository.BookRepository;
import com.dgmf.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
}
