package emt.lab2.bookshop.service;

import emt.lab2.bookshop.model.Book;

import java.util.List;

public interface BookService  {

    public List<Book> getAllBooks();
    public Book getOneBook(Long id);
    public Book createBook(Book book);
    public Book editBook(Book book);
    public void delete(Long id);



}
