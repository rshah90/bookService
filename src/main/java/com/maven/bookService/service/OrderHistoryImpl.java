package com.maven.bookService.service;

import com.maven.bookService.model.Book;
import com.maven.bookService.model.OrderHistory;
import com.maven.bookService.repository.BookRepository;
import com.maven.bookService.repository.OrderHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * The OrderHistoryImpl is represented as Service layer for OrderHistory operations
 */
@Service
public class OrderHistoryImpl implements GenericService<OrderHistory> {

    @Autowired
    private OrderHistoryRepository orderHistoryRepository;

    public OrderHistory getObjectById(long id){
        return orderHistoryRepository.getOne(id);
    };

    public Optional<OrderHistory> findObjectById(long id){
        return orderHistoryRepository.findById(id);
    };


    public List<OrderHistory> findAllObject(){
        return orderHistoryRepository.findAll();
    };

    public List<OrderHistory> findByUserId(Long id){
        return orderHistoryRepository.findByUserId(id);
    };
    public OrderHistory saveObject(OrderHistory orderHistory){
        return orderHistoryRepository.save(orderHistory);
    };

}

