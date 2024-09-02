package com.book.springtask.controller;
import com.book.springtask.entity.Student;
import com.book.springtask.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<Integer> insert(@RequestBody Student student) {
        Student inserted = studentService.insert(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(inserted.getId());
    }

    @GetMapping
    public ResponseEntity<List<Student>> findAll() {
        List<Student> employees = studentService.findAll();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(studentService.findById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<?> findByName(@PathVariable String name) {
        return ResponseEntity.ok(studentService.findByName(name));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Student entity) {
        Student updatedStudentOpt = studentService.update(entity);
            return ResponseEntity.ok(updatedStudentOpt);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id) {
      studentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}