package emt.lab2.bookshop.service.implementation;

import emt.lab2.bookshop.model.Book;
import emt.lab2.bookshop.repository.BookRepository;
import emt.lab2.bookshop.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Book getOneBook(Long id) {
        return bookRepository.getOne(id);
    }

    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book editBook(Book editedBook) {
        Book bookToBeReturned=new Book();
        bookToBeReturned.setCategory(editedBook.getCategory());
        bookToBeReturned.setId(editedBook.getId());
        bookToBeReturned.setName(editedBook.getName());
        bookToBeReturned.setNumberOfBooks(editedBook.getNumberOfBooks());
        bookToBeReturned.setPicture(editedBook.getPicture());
        bookToBeReturned.setShoppingCarts(editedBook.getShoppingCarts());
        return bookToBeReturned;
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);

    }
}
