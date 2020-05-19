package emt.lab2.bookshop.service.implementation;

import emt.lab2.bookshop.model.User;
import emt.lab2.bookshop.repository.UserRepository;
import emt.lab2.bookshop.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getOneUser(String username) {
        return userRepository.getOne(username);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User editedUser(User user) {
        User korisnik= new User();
        korisnik.setUsername(user.getUsername());
        korisnik.setPassword(user.getPassword());
        return user;
    }

    @Override
    public void deleted(User user) {
        userRepository.delete(user);

    }
}
