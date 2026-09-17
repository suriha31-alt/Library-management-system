package com.example.demojava.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demojava.model.mem;
import com.example.demojava.repository.memRepository;

@Service
public class memService {

    private final memRepository repository;

    public memService(memRepository repository) {
        this.repository = repository;
    }

    // ADD MEMBER
    public mem addMember(mem member) {
        return repository.save(member);
    }

    // GET ALL MEMBERS
    public List<mem> getAllMember() {
        return repository.findAll();
    }

    // GET MEMBER BY ID
    public mem getMemberbyId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Member not found"));
    }

    // UPDATE MEMBER
    public mem updateMember(Long id, mem updatedMember) {

        mem existingMember = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Member not found"));

        existingMember.setName(updatedMember.getName());
        existingMember.setPhone(updatedMember.getPhone());
        existingMember.setMail(updatedMember.getMail());

        return repository.save(existingMember);
    }

    // DELETE MEMBER
    public void deleteMember(Long id) {

        if (!repository.existsById(id)) {
            throw new RuntimeException("Member not found");
        }

        repository.deleteById(id);
    }
}