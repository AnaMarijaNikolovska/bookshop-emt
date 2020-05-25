package emt.lab2.bookshop.service.implementation;

import emt.lab2.bookshop.model.Book;
import emt.lab2.bookshop.model.CartItem;
import emt.lab2.bookshop.model.ShoppingCart;
import emt.lab2.bookshop.repository.CartItemRepository;
import emt.lab2.bookshop.service.CartItemService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartItemServiceImpl implements CartItemService {
    private final CartItemRepository cartItemRepository;

    public final BookServiceImpl bookService;

    public CartItemServiceImpl(CartItemRepository cartItemRepository, BookServiceImpl bookService) {
        this.cartItemRepository = cartItemRepository;
        this.bookService = bookService;
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
    public CartItem saveCartItem(CartItem cartItem, ShoppingCart shoppingCart) {
        CartItem newCartItem = new CartItem();

        Optional<Book> nullableBook = bookService.getOneBook(cartItem.getBook().getId());
        if (nullableBook.isPresent()) {
            Book book = nullableBook.get();
            newCartItem.setId(cartItem.getId());
            newCartItem.setBook(book);
            newCartItem.setShoppingCart(shoppingCart);
            return cartItemRepository.save(newCartItem);
        }

        return null;
    }

    @Override
    public CartItem editCartItem(CartItem cartItem) {
        return null;
    }

    @Override
    public void deleteCartItem(Long id) {
        cartItemRepository.deleteById(id);

    }

    @Override
    public List<CartItem> getAllCartItemsFromCart(Long id) {
        return cartItemRepository.findAllByShoppingCartId(id);
    }

    @Override
    public void deleteBooksInShoppingCart(Long id) {
        cartItemRepository.deleteAllByShoppingCartId(id);
    }
}
