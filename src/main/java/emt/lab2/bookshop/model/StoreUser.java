package emt.lab2.bookshop.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@Data
public class StoreUser {
    @Id
    String username;
    String password;
}
