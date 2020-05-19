package emt.lab2.bookshop.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;
    enum Status{
        CREATED, CANCELED, SUCCESS
    }
    LocalDateTime CreateDate;
    LocalDateTime CloseDate;
    @ManyToOne
    User Username;
    @ManyToMany
    List<Book> Books;

}
