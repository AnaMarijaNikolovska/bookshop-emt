package emt.lab2.bookshop.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Enumerated(EnumType.ORDINAL)
    StatusEnum statusEnum;

    LocalDateTime createDate;

    LocalDateTime closeDate;

    @ManyToOne
    StoreUser username;

    public ShoppingCart(LocalDateTime createDate, StatusEnum statusEnum) {
        createDate = createDate;
        statusEnum = statusEnum;
    }
}
