package com.bookland.service;

import com.bookland.model.Book;
import com.bookland.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class BookService {
    private final BookRepository bookRepository;



    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;

    }
    public Optional<Book> findBookById(Integer id){
        return bookRepository.findById(id);
    }
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }
}
