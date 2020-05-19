package emt.lab2.bookshop.service;

import emt.lab2.bookshop.model.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUser();
    public User getOneUser(String username);
    public User saveUser(User user);
    public User editedUser(User user);
    public void deleted(User user);


}
