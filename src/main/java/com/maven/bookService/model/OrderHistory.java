package com.maven.bookService.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
/**
 * OrderHistory class is used to map history object to relational model.
 *
 */
@Entity
@Table(name = "history")
public class OrderHistory implements Serializable {
    public OrderHistory(@NotBlank String title, @NotBlank Long cost, @NotBlank Long quantity, User user) {
        this.title = title;
        this.cost = cost;
        this.quantity = quantity;
        this.user = user;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long purchaseId ;

    @NotBlank
    private String title;

    @NotNull
    private Long cost;

    @NotNull
    private Long quantity;


    @ManyToOne(cascade= CascadeType.MERGE)
    @JoinColumn(name = "user_Id")
    @JsonIgnore
    private User user;

    @Override
    public String toString() {
        return "OrderHistory{" +
                "purchaseId=" + purchaseId +
                ", title='" + title + '\'' +
                ", cost=" + cost +
                ", quantity=" + quantity +
                ", user=" + user +
                '}';
    }

    public OrderHistory(){

    }
    public Long getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Long purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
