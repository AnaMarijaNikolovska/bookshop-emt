package emt.lab2.bookshop.service.implementation;

import emt.lab2.bookshop.model.ShoppingCart;
import emt.lab2.bookshop.repository.ShoppingCartRepository;
import emt.lab2.bookshop.service.ShoppingCartService;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public ShoppingCart getOneShoppingCart(Long id) {

        return shoppingCartRepository.getOne(id);
    }

    @Override
    public ShoppingCart saveShoppingCart(ShoppingCart shoppingCart) {
        return shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public ShoppingCart editedShoppingCart(ShoppingCart shoppingCart) {
        ShoppingCart cart = new ShoppingCart();
        cart.setId(shoppingCart.getId());
        cart.setCloseDate(shoppingCart.getCloseDate());
        cart.setBooks(shoppingCart.getBooks());
        cart.setCreateDate(shoppingCart.getCreateDate());
        cart.setUsername(shoppingCart.getUsername());
        return cart;

    }

    @Override
    public void delete(Long id) {
        shoppingCartRepository.deleteById(id);

    }
}
