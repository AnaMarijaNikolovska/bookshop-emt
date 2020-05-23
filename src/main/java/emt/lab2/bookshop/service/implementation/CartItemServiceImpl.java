package emt.lab2.bookshop.service.implementation;

import emt.lab2.bookshop.model.CartItem;
import emt.lab2.bookshop.repository.CartItemRepository;
import emt.lab2.bookshop.service.CartItemService;

import java.util.List;
import java.util.Optional;

public class CartItemServiceImpl implements CartItemService {
    private final CartItemRepository cartItemRepository;

    public CartItemServiceImpl(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }


    @Override
    public List<CartItem> getAllCartItems() {
        return cartItemRepository.findAll();
    }

    @Override
    public Optional<CartItem> getOneCartItem(Long id) {
        return cartItemRepository.findById(id);
    }

    @Override
    public CartItem saveCartItem(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

    @Override
    public CartItem editCartItem(CartItem cartItem) {
        return null;
    }

    @Override
    public void deleteCartItem(Long id) {
        cartItemRepository.deleteById(id);

    }
}
