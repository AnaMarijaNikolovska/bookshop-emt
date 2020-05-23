package emt.lab2.bookshop.controller;

import emt.lab2.bookshop.model.Book;
import emt.lab2.bookshop.model.ShoppingCart;
import emt.lab2.bookshop.service.implementation.ShoppingCartServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/shoppingCart")
public class ShoppingCartController {
    public final ShoppingCartServiceImpl shoppingCartService;

    public ShoppingCartController(ShoppingCartServiceImpl shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }
    @GetMapping
    public List<ShoppingCart> shoppingCarts() {
        return shoppingCartService.getAllShoppingCart();
    }

    @GetMapping("/{id}")
    public Optional<ShoppingCart> oneShoppingCart(@PathVariable Long id) {
        return shoppingCartService.getOneShoppingCart(id);
    }

    @PostMapping
    public ShoppingCart newCart(ShoppingCart shoppingCart) {
        return shoppingCartService.saveShoppingCart(shoppingCart);
    }
    @PutMapping("/{id}")
    public ShoppingCart editedCart(@RequestBody ShoppingCart shoppingCart, @PathVariable Long id){
        return shoppingCartService.editedShoppingCart(shoppingCart, id);
    }
    @DeleteMapping("/{id}")
    public void deletedCart(@PathVariable Long id){
        shoppingCartService.delete(id);

    }
}

