package emt.lab2.bookshop.service;

import emt.lab2.bookshop.model.CartItem;

import java.util.List;
import java.util.Optional;

public interface CartItemService  {
    public List<CartItem> getAllCartItems();
    public Optional<CartItem> getOneCartItem(Long id);
    public CartItem saveCartItem(CartItem cartItem);
    public CartItem editCartItem(CartItem cartItem);
    public void deleteCartItem(Long id);

}
