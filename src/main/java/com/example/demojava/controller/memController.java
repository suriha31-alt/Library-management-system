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

import com.example.demojava.model.mem;
import com.example.demojava.services.memService;

@RestController
@RequestMapping("/mem")
public class memController {

    private final memService memService;

    public memController(memService service) {
        this.memService = service;
    }

    // GET MEMBER BY ID
    @GetMapping("/{id}")
    public mem getMember(@PathVariable Long id) {
        return memService.getMemberbyId(id);
    }

    // GET ALL MEMBERS
    @GetMapping
    public List<mem> getAllMembers() {
        return memService.getAllMember();
    }

    // ADD MEMBER
    @PostMapping
    public mem addMember(@RequestBody mem member) {
        return memService.addMember(member);
    }

    // UPDATE MEMBER
    @PutMapping("/{id}")
    public mem updateMember(@PathVariable Long id, @RequestBody mem member) {
        return memService.updateMember(id, member);
    }

    // DELETE MEMBER
    @DeleteMapping("/{id}")
    public String deleteMember(@PathVariable Long id) {
        memService.deleteMember(id);
        return "Member deleted successfully";
    }
}