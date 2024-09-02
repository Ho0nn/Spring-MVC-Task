package com.book.springtask.controller;

import com.book.springtask.entity.Instructor;
import com.book.springtask.entity.Student;
import com.book.springtask.services.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instructor")
public class InstructorController {
    @Autowired
    private InstructorService instructorService;

    @PostMapping
    public ResponseEntity<Integer> insert(@RequestBody Instructor ins) {
        Instructor inserted = instructorService.insert(ins);
        return ResponseEntity.status(HttpStatus.CREATED).body(inserted.getId());
    }

    @GetMapping
    public ResponseEntity<List<Instructor>> findAll() {
        List<Instructor> instructors = instructorService.findAll();
        return ResponseEntity.ok(instructors);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(instructorService.findById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<?> findByName(@PathVariable String name) {
        return ResponseEntity.ok(instructorService.findByName(name));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Instructor entity) {
        Instructor updatedInstructor = instructorService.update(entity);
            return ResponseEntity.ok(updatedInstructor);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id) {
      instructorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}