package emt.lab2.bookshop.service;

import emt.lab2.bookshop.model.StoreUser;

import java.util.List;
import java.util.Optional;

public interface UserService {
     List<StoreUser> getAllUser();
     Optional<StoreUser> getOneUser(String username);
     StoreUser saveUser(StoreUser storeUser);
     StoreUser editedUser(StoreUser storeUser, String username);
     void deleted(StoreUser storeUser);
     StoreUser getAuthUser();


}
