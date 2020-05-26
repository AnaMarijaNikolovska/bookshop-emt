package emt.lab2.bookshop.service.implementation;

import emt.lab2.bookshop.model.*;
import emt.lab2.bookshop.repository.ShoppingCartRepository;
import emt.lab2.bookshop.service.CartItemService;
import emt.lab2.bookshop.service.ShoppingCartService;
import emt.lab2.bookshop.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;

    private final CartItemService cartItemService;
    private final UserService userService;

    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository,
                                   CartItemService cartItemService, UserService userService) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.cartItemService = cartItemService;
        this.userService = userService;
    }

    @Override
    public List<ShoppingCart> getAllShoppingCart() {
        return shoppingCartRepository.findAll();
    }

    @Override
    public Optional<ShoppingCart> getOneShoppingCart(Long id) {

        return shoppingCartRepository.findById(id);
    }

    @Override
    public ShoppingCart saveShoppingCart(List<CartItem> cartItems) {

        StoreUser user = userService.getAuthUser();

        ShoppingCart newShoppingCart = shoppingCartRepository.save(new ShoppingCart(LocalDateTime.now(), StatusEnum.CREATED, user));

        for (CartItem cartItem : cartItems) {
            cartItemService.saveCartItem(cartItem, newShoppingCart);
        }

        return newShoppingCart;
    }

    @Override
    public ShoppingCart editedShoppingCart(Long id, Book book, Boolean isAdd) {
        Optional<ShoppingCart> nullableCart = getOneShoppingCart(id);

        if (nullableCart.isPresent()) {
            List<CartItem> cartItems = cartItemService.getAllCartItemsFromCart(id);

            for (CartItem cartItem: cartItems) {
                if (cartItem.getBook().getId().equals(book.getId())) {
                    cartItemService.editCartItem(cartItem, book, isAdd);

                }
            }

            return saveShoppingCart(cartItems);
        }

        return null;
    }

    @Override
    public void delete(Long id) {
        shoppingCartRepository.deleteById(id);
    }

    @Override
    public ShoppingCart closeShoppingCart(Long id) {
        Optional<ShoppingCart> optionalShoppingCart = getOneShoppingCart(id);
        if (optionalShoppingCart.isPresent()) {
            ShoppingCart cart = optionalShoppingCart.get();
            cart.setStatusEnum(StatusEnum.CANCELED);
            cart.setCloseDate(LocalDateTime.now());
            cartItemService.deleteBooksInShoppingCart(id);
            return cart;
        }
        return null;
    }
}
