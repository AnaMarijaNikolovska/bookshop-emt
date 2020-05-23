package emt.lab2.bookshop.service.implementation;

import emt.lab2.bookshop.model.Book;
import emt.lab2.bookshop.model.Category;
import emt.lab2.bookshop.repository.CategoryRepository;
import emt.lab2.bookshop.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;

    }

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> getOneCategory(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category editCategory(Category category, Long id) {

        Optional<Category> category1=getOneCategory(id);
        if (category1.isPresent()){
            Category kategorija= category1.get();
            kategorija.setId(category.getId());
            kategorija.setName(category.getName());
            kategorija.setDescription(category.getDescription());
            return saveCategory(kategorija);
        }
        return null;


    }

    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);

    }
}
