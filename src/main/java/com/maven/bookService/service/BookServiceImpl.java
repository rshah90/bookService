package com.maven.bookService.service;

import com.maven.bookService.model.Book;
import com.maven.bookService.model.User;
import com.maven.bookService.repository.BookRepository;
import com.maven.bookService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


/**
 * The BookServiceImpl is represented as Service layer for Book operations
 */
@Service
public class BookServiceImpl implements GenericService<Book> {

    @Autowired
    private BookRepository bookRepository;

    public Book getObjectById(long id){
        return bookRepository.getOne(id);
    };

    public Optional<Book> findObjectById(long id){
        return bookRepository.findById(id);
    };


    public List<Book> findAllObject(){
        return bookRepository.findAll();
    };

    public Page<Book> findAllObjectByPaging(Integer page , Integer size){
        Pageable pageable = new PageRequest(page, size);
        return bookRepository.findAll(pageable);
    };

    public Book saveObject(Book book){
        return bookRepository.save(book);
    };

}

