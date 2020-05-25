package emt.lab2.bookshop.service.implementation;

import emt.lab2.bookshop.model.Book;
import emt.lab2.bookshop.model.Category;
import emt.lab2.bookshop.repository.BookRepository;
import emt.lab2.bookshop.service.BookService;
import emt.lab2.bookshop.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final CategoryService categoryService;

    public BookServiceImpl(BookRepository bookRepository, CategoryService categoryService) {
        this.bookRepository = bookRepository;
        this.categoryService = categoryService;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> getOneBook(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book createBook(Book book) {

        Optional<Category> optionalCategory = categoryService.getOneCategory(book.getCategory().getId());
        Category category = new Category();
        if (optionalCategory.isPresent()) {
            category = optionalCategory.get();
        }

        Book newBook = new Book();
        newBook.setCategory(category);
        newBook.setName(book.getName());
        newBook.setNumberOfBooks(book.getNumberOfBooks());
        newBook.setPicture(book.getPicture());

        return bookRepository.save(newBook);
    }

    @Override
    public Book editBook(Book editedBook, Long id) {
        Optional<Book> updatedBook = getOneBook(id);
        if (updatedBook.isPresent()) {
            Book bookToBeReturned = updatedBook.get();
            bookToBeReturned.setCategory(editedBook.getCategory());
            bookToBeReturned.setId(editedBook.getId());
            bookToBeReturned.setName(editedBook.getName());
            bookToBeReturned.setNumberOfBooks(editedBook.getNumberOfBooks());
            bookToBeReturned.setPicture(editedBook.getPicture());
            return createBook(bookToBeReturned);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);

    }
}
