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

import com.example.demojava.model.auth;
import com.example.demojava.services.authService;

@RestController
@RequestMapping("/auth")
public class authController {

    private final authService authService;

    public authController(authService service) {
        this.authService = service;
    }

    // GET AUTHOR BY ID
    @GetMapping("/{id}")
    public auth getAuthor(@PathVariable Long id) {
        return authService.getAuthorbyId(id);
    }

    // GET ALL AUTHORS
    @GetMapping
    public List<auth> getAllAuthors() {
        return authService.getAllAuthor();
    }

    // ADD AUTHOR
    @PostMapping
    public auth addAuthor(@RequestBody auth author) {
        return authService.addAuthor(author);
    }

    // UPDATE AUTHOR
    @PutMapping("/{id}")
    public auth updateAuthor(@PathVariable Long id, @RequestBody auth author) {
        return authService.updateAuthor(id, author);
    }

    // DELETE AUTHOR
    @DeleteMapping("/{id}")
    public String deleteAuthor(@PathVariable Long id) {
        authService.deleteAuthor(id);
        return "Author deleted successfully";
    }
}