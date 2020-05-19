package emt.lab2.bookshop.repository;

import emt.lab2.bookshop.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long>{


}