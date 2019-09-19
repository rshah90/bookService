package com.maven.bookService.repository;

import com.maven.bookService.model.Book;
import com.maven.bookService.model.OrderHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * The OrderHistoryRepository is used for CRUD operation for History table
 */
@Repository
public interface OrderHistoryRepository extends JpaRepository<OrderHistory,Long>  {
    List<OrderHistory> findByUserId(Long id);
}
