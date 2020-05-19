package emt.lab2.bookshop.controller;

import emt.lab2.bookshop.model.Category;
import emt.lab2.bookshop.service.implementation.CategoryServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Category returnOne(@PathVariable Long id){
        return categoryService.getOneCategory(id);
    }

}
