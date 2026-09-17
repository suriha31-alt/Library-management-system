package com.example.demojava.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demojava.model.book;
import com.example.demojava.services.bookService;

@RestController
@RequestMapping("/book")
public class bookController {

    private final bookService bookService;

    public bookController(bookService service) {
        this.bookService = service;
    }

    // GET BY ID
    @GetMapping("/{id}")
    public book getBook(@PathVariable Long id) {
        return bookService.getBookbyId(id);
    }

    // GET ALL BOOKS
    @GetMapping
    public List<book> getAllBooks() {
        return bookService.getAllBook();
    }

    // ADD BOOK
    @PostMapping
    public book addBook(@RequestBody book book) {
        return bookService.addBook(book);
    }

    // UPDATE BOOK
    @PutMapping("/{id}")
    public book updateBook(@PathVariable Long id, @RequestBody book book) {
        return bookService.updateBook(id, book);
    }

    // DELETE BOOK
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "Book deleted successfully";
    }
}