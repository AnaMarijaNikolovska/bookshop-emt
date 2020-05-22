package emt.lab2.bookshop.service.implementation;

import emt.lab2.bookshop.model.StoreUser;
import emt.lab2.bookshop.repository.UserRepository;
import emt.lab2.bookshop.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<StoreUser> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public Optional<StoreUser> getOneUser(String username) {
        return userRepository.findById(username);
    }

    @Override
    public StoreUser saveUser(StoreUser storeUser) {
        return userRepository.save(storeUser);
    }

    @Override
    public StoreUser editedUser(StoreUser storeUser) {
        StoreUser korisnik= new StoreUser();
        korisnik.setUsername(storeUser.getUsername());
        korisnik.setPassword(storeUser.getPassword());
        return storeUser;
    }

    @Override
    public void deleted(StoreUser storeUser) {
        userRepository.delete(storeUser);

    }
}
