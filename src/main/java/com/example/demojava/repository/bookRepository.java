package com.example.demojava.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demojava.model.book;
public interface bookRepository extends JpaRepository<book,Long> {
    
}
