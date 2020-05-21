package emt.lab2.bookshop.service;

import emt.lab2.bookshop.model.Book;
import emt.lab2.bookshop.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    public List<Category> getAllCategory();
    public Optional<Category> getOneCategory(Long id);
    public Category saveCategory(Category category);
    public Category editCategory(Category category);
    public void delete(Long id);

}
