package emt.lab2.bookshop.service;

import emt.lab2.bookshop.model.StoreUser;

import java.util.List;

public interface UserService {
    public List<StoreUser> getAllUser();
    public StoreUser getOneUser(String username);
    public StoreUser saveUser(StoreUser storeUser);
    public StoreUser editedUser(StoreUser storeUser);
    public void deleted(StoreUser storeUser);


}
