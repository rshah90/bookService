package com.maven.bookService;

import com.maven.bookService.model.Book;
import com.maven.bookService.model.User;
import com.maven.bookService.repository.BookRepository;
import com.maven.bookService.repository.UserRepository;
import com.maven.bookService.service.BookServiceImpl;
import com.maven.bookService.service.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookServiceImpl bookService;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetBook(){
        Book book = new Book();
        book.setInventoryId(5L);
        book.setTitle("The Spring Book");
        book.setISBN("Test");
        book.setQuantity(10L);
        book.setCost(100L);
        when(bookRepository.getOne(5L)).thenReturn(book);

        Book result = bookService.getObjectById(5L);
        assertEquals(5L, result.getInventoryId().longValue());
    }

    @Test
    public void testSaveUser(){
        Book book = new Book();
        book.setInventoryId(5L);
        book.setTitle("The Spring Book");
        book.setISBN("Test");
        book.setQuantity(10L);
        book.setCost(100L);
        when(bookRepository.save(book)).thenReturn(book);
        Book result = bookService.saveObject(book);
        assertEquals(5L, result.getInventoryId().longValue());
        assertEquals("The Spring Book", result.getTitle());
    }
}
