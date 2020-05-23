package emt.lab2.bookshop.service;

import emt.lab2.bookshop.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService  {

    public List<Book> getAllBooks();
    public Optional<Book> getOneBook(Long id);
    public Book createBook(Book book);
    public Book editBook(Book book, Long id);
    public void delete(Long id);



}
