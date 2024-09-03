package com.book.springtask.controller;

import com.book.springtask.entity.Instructor;
import com.book.springtask.entity.Quiz;
import com.book.springtask.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    private QuizService quizService;

    @PostMapping
    public ResponseEntity<Integer> insert(@RequestBody Quiz quiz) {
        Quiz inserted = quizService.insert(quiz);
        return ResponseEntity.status(HttpStatus.CREATED).body(inserted.getId());
    }

    @GetMapping
    public ResponseEntity<List<Quiz>> findAll() {
        List<Quiz> quizzes = quizService.findAll();
        return ResponseEntity.ok(quizzes);
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(quizService.findById(id));
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> findByName(@PathVariable String name) {
        return ResponseEntity.ok(quizService.findByCourseName(name));
    }
    @PutMapping
    public ResponseEntity<?> update(@RequestBody Quiz entity) {
        Quiz quiz = quizService.update(entity);
            return ResponseEntity.ok(quiz);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id) {
      quizService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}