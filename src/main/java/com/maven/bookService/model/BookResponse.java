package com.maven.bookService.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import  java.util.ArrayList
/**
 * BookResponse class is used to map the Book Response for Add Book api.
 *
 */
public class BookResponse implements Serializable {

    private Long inventoryId;

    public BookResponse(Long inventoryId, String title, String isbn, Long cost, Long quantity) {
        this.inventoryId = inventoryId;
        this.title = title;
        this.isbn = isbn;
        this.cost = cost;
        this.quantity = quantity;
    }

    private String title;
    private String isbn;
    private Long cost;
    private Long quantity;

    public Long getInventoryId() {
        return inventoryId;
    }

    @Override
    public String toString() {
        return "Book{" +
                "inventoryId=" + inventoryId +
                ", title='" + title + '\'' +
                ", ISBN='" + isbn + '\'' +
                ", cost=" + cost +
                ", quantity=" + quantity +
                '}';
    }

    public void setInventoryId(Long inventoryId) {
        this.inventoryId = inventoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getISBN() {
        return isbn;
    }

    public void setISBN(String ISBN) {
        this.isbn = ISBN;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }


}
