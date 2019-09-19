package com.maven.bookService.controllers;

import com.maven.bookService.model.*;
import com.maven.bookService.repository.BookRepository;
import com.maven.bookService.repository.OrderHistoryRepository;
import com.maven.bookService.service.BookServiceImpl;
import com.maven.bookService.service.OrderHistoryImpl;
import com.maven.bookService.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * The BookController is used for operations pertaining to User
 *
 */

@RestController
@Api(value="onlinestore", description="Operations pertaining to User in Online Store")
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private BookServiceImpl bookServiceImpl;

    @Autowired
    private OrderHistoryImpl orderHistoryImpl;

    // Add User api used to create the new User
    @ApiOperation(value = "Add a User")
    @RequestMapping(value = "/create-user", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "http://localhost:4200")
    public UserResponse AddUser(@RequestBody User user) {
        logger.info("user:" + user.toString());
        User DBUser = userService.saveObject(user);
        return new UserResponse(DBUser.getId(),DBUser.getFirstName(),DBUser.getLastName(),DBUser.getEmailAddress());
    }

    //this api is used to get User information includes user data and order History
    @ApiOperation(value = "View a user with list of order History",response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
    }
    )
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/get-user", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public GetUserDetails GetUser(@RequestParam("id") Long id) {
        User user = userService.getObjectById(id);
        logger.info("user:" + user);
        List<OrderHistory> orders = orderHistoryImpl.findByUserId(id);
        GetUserDetails userData = new GetUserDetails(id, user.getEmailAddress(), orders);
        logger.info("user:" + orders);
        return userData;
    }


    // Add Purchase - this api update the inventory and also order history for particular user.
    @ApiOperation(value = "Add a purchase")
    @RequestMapping(value = "/new-purchase", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public OrderHistory NewPurchase(@RequestBody Purchase purchase) {

        return userService.findObjectById(purchase.getId()).map(user -> {
                    Optional<OrderHistory> orderHistory = bookServiceImpl.findObjectById(purchase.getInventoryId()).map(
                            book -> {
                                book.setQuantity(book.getQuantity() - purchase.getQuantity());
                                bookServiceImpl.saveObject(book);

                                OrderHistory orderHist = new OrderHistory(book.getTitle(), book.getCost(), purchase.getQuantity(), user);
                                return orderHistoryImpl.saveObject(orderHist);
                            }

                    );
                    return orderHistory;
                }
        ).get().get();
    }


}
