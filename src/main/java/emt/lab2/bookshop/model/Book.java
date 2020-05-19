package emt.lab2.bookshop.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;
    String Name;
    Long NumberOfBooks;
    @ManyToOne(fetch = FetchType.EAGER)
    Category Category;
    String Picture;
    @ManyToMany
    List<ShoppingCart> ShoppingCarts;



}
