package emt.lab2.bookshop.service.implementation;

import emt.lab2.bookshop.model.ShoppingCart;
import emt.lab2.bookshop.repository.ShoppingCartRepository;
import emt.lab2.bookshop.service.ShoppingCartService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;


    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
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
    public ShoppingCart saveShoppingCart(ShoppingCart shoppingCart) {
        return shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public ShoppingCart editedShoppingCart(ShoppingCart shoppingCart, Long id) {
        Optional<ShoppingCart> optionalShoppingCart = getOneShoppingCart(id);
        if (optionalShoppingCart.isPresent()) {
            ShoppingCart cart = optionalShoppingCart.get();

            cart.setId(shoppingCart.getId());
            cart.setCloseDate(shoppingCart.getCloseDate());
            cart.setCartItem(shoppingCart.getCartItem());
            cart.setCreateDate(shoppingCart.getCreateDate());
            cart.setUsername(shoppingCart.getUsername());
            return saveShoppingCart(cart);
        }
        return null;


    }

    @Override
    public void delete(Long id) {
        shoppingCartRepository.deleteById(id);

    }
}
