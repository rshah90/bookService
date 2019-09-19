package com.maven.bookService.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

/**
 * GetUserDetails class is used to map the user Details Response for Get User api.
 *
 */
public class GetUserDetails implements Serializable {

    private Long id;

    private String emailAddress;

    public GetUserDetails(Long id, String emailAddress, List<OrderHistory> orderHistory) {
        this.id = id;
        this.emailAddress = emailAddress;
        this.orderHistory = orderHistory;
    }

    private List<OrderHistory> orderHistory;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }


    public List<OrderHistory> getOrderHistory() {
        return orderHistory;
    }

    public void setOrderHistory(List<OrderHistory> orderHistory) {
        this.orderHistory = orderHistory;
    }

    @Override
    public String toString() {
        return "GetUserDetails{" +
                "id=" + id +
                ", emailAddress='" + emailAddress + '\'' +
                ", orderHistory=" + orderHistory +
                '}';
    }

}
