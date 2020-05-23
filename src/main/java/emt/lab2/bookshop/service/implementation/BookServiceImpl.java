package emt.lab2.bookshop.service.implementation;

import emt.lab2.bookshop.model.Book;
import emt.lab2.bookshop.repository.BookRepository;
import emt.lab2.bookshop.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
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
        return bookRepository.save(book);
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
            bookToBeReturned.setCartItem(editedBook.getCartItem());
            return createBook(bookToBeReturned);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);

    }
}
