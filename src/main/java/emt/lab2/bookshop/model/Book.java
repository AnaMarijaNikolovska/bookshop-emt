package emt.lab2.bookshop.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    Long numberOfBooks;
    @ManyToOne
    Category category;
    String picture;
}
