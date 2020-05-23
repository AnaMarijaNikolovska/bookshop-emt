package emt.lab2.bookshop.repository;

import emt.lab2.bookshop.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem,Long> {
}
