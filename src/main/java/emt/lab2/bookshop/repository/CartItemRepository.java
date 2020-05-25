package emt.lab2.bookshop.repository;

import emt.lab2.bookshop.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem,Long> {
    public List<CartItem> findAllByShoppingCartId(Long id);
}
