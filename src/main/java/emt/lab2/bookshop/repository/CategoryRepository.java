package emt.lab2.bookshop.repository;

import emt.lab2.bookshop.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
