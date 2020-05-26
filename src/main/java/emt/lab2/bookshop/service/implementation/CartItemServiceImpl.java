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

            if (book.getNumberOfBooks() > 0) {
                Book bookToBeAdded = new Book(book.getId(), book.getName(), book.getNumberOfBooks(), book.getCategory(), book.getPicture()); // kopija od objektot shto sakame da go stavime
                bookToBeAdded.setNumberOfBooks(1L);

                newCartItem.setId(cartItem.getId());
                newCartItem.setBook(bookToBeAdded); // 1 kniga
                newCartItem.setShoppingCart(shoppingCart);

                book.setNumberOfBooks(book.getNumberOfBooks() - bookToBeAdded.getNumberOfBooks()); // Odzemi od vkupniot broj - 1 (dodadenata kniga)
                bookService.editBook(book, book.getId());

                return cartItemRepository.save(newCartItem);
            }
        }

        return null;
    }

    @Override
    public CartItem editCartItem(CartItem cartItem, Book book, Boolean isAdd) {
        Book editedBook = bookService.getOneBook(book.getId()).get();

        if (isAdd) { // +
            if (editedBook.getNumberOfBooks() > 0) {
                cartItem.getBook().setNumberOfBooks(cartItem.getBook().getNumberOfBooks() + 1);
                editedBook.setNumberOfBooks(editedBook.getNumberOfBooks() - 1);
                bookService.editBook(editedBook, book.getId());
            }
        } else { // -
            if (cartItem.getBook().getNumberOfBooks() > 0 ){
                cartItem.getBook().setNumberOfBooks(cartItem.getBook().getNumberOfBooks() - 1);
                editedBook.setNumberOfBooks(editedBook.getNumberOfBooks() + 1);
                bookService.editBook(editedBook, book.getId());
            }
        }

        return cartItem;
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
