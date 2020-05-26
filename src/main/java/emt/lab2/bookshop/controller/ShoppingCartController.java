package emt.lab2.bookshop.controller;

import emt.lab2.bookshop.model.CartItem;
import emt.lab2.bookshop.model.ShoppingCart;
import emt.lab2.bookshop.service.CartItemService;
import emt.lab2.bookshop.service.implementation.ShoppingCartServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shopping-carts")
public class ShoppingCartController {
    public final ShoppingCartServiceImpl shoppingCartService;
    public final CartItemService cartItemService;

    public ShoppingCartController(ShoppingCartServiceImpl shoppingCartService, CartItemService cartItemService) {
        this.shoppingCartService = shoppingCartService;
        this.cartItemService = cartItemService;
    }

    @GetMapping
    public List<ShoppingCart> shoppingCarts() {
        return shoppingCartService.getAllShoppingCart();
    }

    @GetMapping("/{id}")
    public List<CartItem> oneShoppingCart(@PathVariable Long id) {
        return cartItemService.getAllCartItemsFromCart(id);
    }

    @PostMapping
    public ShoppingCart newCart(@RequestBody List<CartItem> cartItems) {
        return shoppingCartService.saveShoppingCart(cartItems);
    }

    @DeleteMapping("/{id}")
    public void deletedCart(@PathVariable Long id) {
        shoppingCartService.delete(id);
    }

    @PostMapping("/{id}/close")
    public ShoppingCart closeCart(@PathVariable Long id) {
        return shoppingCartService.closeShoppingCart(id);
    }


//    @PutMapping("/{id}")
//    public ShoppingCart editedCart(@RequestBody ShoppingCart shoppingCart, @PathVariable Long id){
//        return shoppingCartService.editedShoppingCart(shoppingCart, id);
//    }
}

