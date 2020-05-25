package emt.lab2.bookshop.controller;

import emt.lab2.bookshop.model.Book;
import emt.lab2.bookshop.service.implementation.BookServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/book")
public class BookController {

    public final BookServiceImpl bookService;

    public BookController(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> allBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Optional<Book> oneBook(@PathVariable Long id) {
        return bookService.getOneBook(id);
    }

    @DeleteMapping
    public void bookDeleted(Long id) {
        bookService.delete(id);
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }

    @PutMapping("/{id}")
    public Book editedBook(@PathVariable Long id, @RequestBody Book book) {
        return bookService.editBook(book, id);
    }
}
