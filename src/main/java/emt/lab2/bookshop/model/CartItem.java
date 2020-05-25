package emt.lab2.bookshop.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // avtomatsko generiranje na ID
    Long id;

    @ManyToOne
    Book book;

    @ManyToOne
    ShoppingCart shoppingCart;
}
