package com.example.demojava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demojava.model.auth;

public interface authRepository extends JpaRepository<auth, Long> {

}