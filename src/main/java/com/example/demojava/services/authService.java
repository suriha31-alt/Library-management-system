package com.example.demojava.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demojava.model.auth;
import com.example.demojava.repository.authRepository;

@Service
public class authService {

    private final authRepository repository;

    public authService(authRepository repository) {
        this.repository = repository;
    }

    // ADD AUTHOR
    public auth addAuthor(auth author) {
        return repository.save(author);
    }

    // GET ALL AUTHORS
    public List<auth> getAllAuthor() {
        return repository.findAll();
    }

    // GET AUTHOR BY ID
    public auth getAuthorbyId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found"));
    }

    // UPDATE AUTHOR
    public auth updateAuthor(Long id, auth updatedAuthor) {

        auth existingAuthor = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found"));

        existingAuthor.setName(updatedAuthor.getName());
        existingAuthor.setCountry(updatedAuthor.getCountry());

        return repository.save(existingAuthor);
    }

    // DELETE AUTHOR
    public void deleteAuthor(Long id) {

        if (!repository.existsById(id)) {
            throw new RuntimeException("Author not found");
        }

        repository.deleteById(id);
    }
}