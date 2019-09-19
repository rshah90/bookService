package com.maven.bookService.repository;

import com.maven.bookService.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The BookRepository is used for CRUD operation for Book table
 */

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
