package emt.lab2.bookshop.service;

import emt.lab2.bookshop.model.CartItem;
import emt.lab2.bookshop.model.ShoppingCart;

import java.util.List;
import java.util.Optional;

public interface ShoppingCartService {
    List<ShoppingCart> getAllShoppingCart();
    Optional<ShoppingCart> getOneShoppingCart(Long id);
    ShoppingCart saveShoppingCart(List<CartItem> cartItems);
    ShoppingCart editedShoppingCart(ShoppingCart shoppingCart, Long id);
    void delete(Long id);
    ShoppingCart closeShoppingCart(Long id);
}
