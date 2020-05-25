package emt.lab2.bookshop.service.implementation;

import emt.lab2.bookshop.model.CartItem;
import emt.lab2.bookshop.model.ShoppingCart;
import emt.lab2.bookshop.model.StatusEnum;
import emt.lab2.bookshop.repository.ShoppingCartRepository;
import emt.lab2.bookshop.service.CartItemService;
import emt.lab2.bookshop.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;

    private final CartItemService cartItemService;

    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository,
                                   CartItemService cartItemService) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.cartItemService = cartItemService;
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
       ShoppingCart newShoppingCart = shoppingCartRepository.save(new ShoppingCart(LocalDateTime.now(), StatusEnum.CREATED));

//        for (CartItem cartItem : cartItemService.getAllCartItemsFromCart(shoppingCart.getId())) {
//            cartItemService.saveCartItem(cartItem, shoppingCart);
//        }

        for (CartItem cartItem : cartItems) {
            cartItemService.saveCartItem(cartItem, newShoppingCart);
        }

        return newShoppingCart;
    }

    @Override
    public ShoppingCart editedShoppingCart(ShoppingCart shoppingCart, Long id) {
        Optional<ShoppingCart> optionalShoppingCart = getOneShoppingCart(id);
//        if (optionalShoppingCart.isPresent()) {
//            ShoppingCart cart = optionalShoppingCart.get();
//
//            cart.setId(shoppingCart.getId());
//            cart.setCloseDate(shoppingCart.getCloseDate());
//            cart.setCreateDate(shoppingCart.getCreateDate());
//            cart.setUsername(shoppingCart.getUsername());
//            return saveShoppingCart(cart);
//        }
        return null;


    }

    @Override
    public void delete(Long id) {
        shoppingCartRepository.deleteById(id);
    }
}
