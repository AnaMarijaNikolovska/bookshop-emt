package emt.lab2.bookshop.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="category")
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;
    String Name;
    String Description;
}
