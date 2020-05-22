package emt.lab2.bookshop.service;

import emt.lab2.bookshop.model.ShoppingCart;

import java.util.List;
import java.util.Optional;

public interface ShoppingCartService {
    public List<ShoppingCart> getAllShoppingCart();
    public Optional<ShoppingCart> getOneShoppingCart(Long id);
    public ShoppingCart saveShoppingCart(ShoppingCart shoppingCart);
    public ShoppingCart editedShoppingCart(ShoppingCart shoppingCart);
    public void delete(Long id);
}
