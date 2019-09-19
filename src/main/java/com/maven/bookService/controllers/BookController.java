package com.maven.bookService.controllers;

import com.maven.bookService.model.*;
import com.maven.bookService.repository.BookRepository;
import com.maven.bookService.service.BookServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The BookController is used for operations pertaining to Book
 *
 */

@RestController
@Api(value="onlinestore", description="Operations pertaining to Book in Online Store")
public class BookController {

    Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookServiceImpl bookServiceImpl;


    // Add Book is used to create new book in the inventory
    @ApiOperation(value = "Add a Book")
    @RequestMapping(value = "/add-book", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "http://localhost:4200")
    public BookResponse AddBook(@RequestBody Book book) {
        logger.info("book:" + book.toString());
        Book DBBook = bookServiceImpl.saveObject(book);
        return new BookResponse(DBBook.getInventoryId(),DBBook.getTitle(),DBBook.getISBN(),DBBook.getCost(),DBBook.getQuantity());
    }

    // Get Book is used to get he lost of books based on page and size passed in the request
    @ApiOperation(value = "View inventory with list of books",response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
    }
    )
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/get-book", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Book> GetBook(@RequestParam("page") int page,
                              @RequestParam("size") int size) {
        Page<Book> books = bookServiceImpl.findAllObjectByPaging(page , size);
        logger.info("book:" + books);
        return books.getContent();
    }

}
