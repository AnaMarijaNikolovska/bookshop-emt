package emt.lab2.bookshop.service;

import emt.lab2.bookshop.model.CartItem;
import emt.lab2.bookshop.model.ShoppingCart;

import java.util.List;
import java.util.Optional;

public interface CartItemService  {
    List<CartItem> getAllCartItems();
    Optional<CartItem> getOneCartItem(Long id);
    CartItem saveCartItem(CartItem cartItem, ShoppingCart shoppingCart);
    CartItem editCartItem(CartItem cartItem);
    void deleteCartItem(Long id);
    List<CartItem> getAllCartItemsFromCart(Long id);


}
