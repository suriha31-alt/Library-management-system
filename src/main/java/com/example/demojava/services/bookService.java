package com.example.demojava.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demojava.model.book;
import com.example.demojava.repository.bookRepository;

@Service
public class bookService {

    private final bookRepository repository;

    public bookService(bookRepository repository) {
        this.repository = repository;
    }

    // ADD BOOK
    public book addBook(book book) {
        return repository.save(book);
    }

    // GET ALL BOOKS
    public List<book> getAllBook() {
        return repository.findAll();
    }

    // GET BOOK BY ID
    public book getBookbyId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }

    // UPDATE BOOK
    public book updateBook(Long id, book updatedBook) {

        book existingBook = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        existingBook.setBookName(updatedBook.getBookName());
        existingBook.setAuthor(updatedBook.getAuthor());
        existingBook.setPrice(updatedBook.getPrice());

        return repository.save(existingBook);
    }

    // DELETE BOOK
    public void deleteBook(Long id) {

        if (!repository.existsById(id)) {
            throw new RuntimeException("Book not found");
        }

        repository.deleteById(id);
    }
}