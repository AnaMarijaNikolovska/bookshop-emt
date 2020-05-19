package emt.lab2.bookshop.controller;

import emt.lab2.bookshop.service.implementation.BookServiceImpl;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    public final BookServiceImpl bookService;

    public BookController(BookServiceImpl bookService) {
        this.bookService = bookService;

    }


}
