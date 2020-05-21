package emt.lab2.bookshop.repository;

import emt.lab2.bookshop.model.StoreUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<StoreUser,String> {
}
