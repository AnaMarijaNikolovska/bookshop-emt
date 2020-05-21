package emt.lab2.bookshop.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
public class CartItem {
    @Id
    Long id;
    @ManyToOne
    Book book;
    @ManyToOne
    ShoppingCart shoppingCart;



}
