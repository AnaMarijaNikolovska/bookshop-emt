package emt.lab2.bookshop.service;

import emt.lab2.bookshop.model.CartItem;
import emt.lab2.bookshop.model.ShoppingCart;

import java.util.List;
import java.util.Optional;

public interface ShoppingCartService {
    public List<ShoppingCart> getAllShoppingCart();
    public Optional<ShoppingCart> getOneShoppingCart(Long id);
    public ShoppingCart saveShoppingCart(List<CartItem> cartItems);
    public ShoppingCart editedShoppingCart(ShoppingCart shoppingCart, Long id);
    public void delete(Long id);
}
