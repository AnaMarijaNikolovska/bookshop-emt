package emt.lab2.bookshop.service;

import emt.lab2.bookshop.model.StoreUser;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public List<StoreUser> getAllUser();
    public Optional<StoreUser> getOneUser(String username);
    public StoreUser saveUser(StoreUser storeUser);
    public StoreUser editedUser(StoreUser storeUser, String username);
    public void deleted(StoreUser storeUser);


}
