package emt.lab2.bookshop.controller;

import emt.lab2.bookshop.model.StoreUser;
import emt.lab2.bookshop.service.implementation.UserServiceImpl;
import org.apache.tomcat.jni.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<StoreUser> allUsers() {
        return userService.getAllUser();
    }

    @DeleteMapping
    public void delete(@RequestBody StoreUser storeUser) {
        userService.deleted(storeUser);
    }

    @PostMapping
    public StoreUser create(@RequestBody StoreUser storeUser) {
        return userService.saveUser(storeUser);
    }

    @GetMapping("/{username}")
    public Optional<StoreUser> user(@PathVariable String username) {
        return userService.getOneUser(username);
    }

    @PutMapping("/{username}")
    public StoreUser editedUser(@PathVariable String username, @RequestBody StoreUser storeUser) {
        return userService.editedUser(storeUser,username);

    }


}
