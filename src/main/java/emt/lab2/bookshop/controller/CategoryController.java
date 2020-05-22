package emt.lab2.bookshop.controller;

import emt.lab2.bookshop.model.Category;
import emt.lab2.bookshop.service.implementation.CategoryServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/category")
public class CategoryController {
    private final CategoryServiceImpl categoryService;

    public CategoryController(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> returnAll() {
        return categoryService.getAllCategory();
    }

    @PostMapping
    public Category addCategory(@RequestBody Category category) {
        return categoryService.saveCategory(category);
    }

    @GetMapping("/{id}")
    public Optional<Category> returnOne(@PathVariable Long id) {
        return categoryService.getOneCategory(id);
    }


    @DeleteMapping("/{id}")
    public void deleted(@PathVariable Long id) {
        categoryService.delete(id);
    }

    @PutMapping("/{id}")
    public Category edited(@PathVariable Long id, @RequestBody Category category) {
        return categoryService.editCategory(category, id);

    }


}
