package com.maven.bookService.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


/**
 * Book class is used to map book object to relational model.
 *
 */

@Entity
@Table(name = "books")
public class Book implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="inventoryId")
    private Long inventoryId ;

    @NotBlank(message = "Please enter title")
    private String title;

    @NotBlank(message = "Please enter isbn")
    private String isbn;

    @NotNull(message = "Please enter cost")
    private Long cost;

    @NotNull(message = "Please enter quantity")
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
