package com.book.springtask.controller;

import com.book.springtask.entity.Course;
import com.book.springtask.entity.CourseDTO;
import com.book.springtask.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    public ResponseEntity<String> insert(@RequestBody CourseDTO courseDto) {
        courseService.insert(courseDto.toEntity(), courseDto.getInstructorId());
        return ResponseEntity.ok("Course created successfully");

    }

    @GetMapping
    public ResponseEntity<List<Course>> findAll() {
        List<Course> courses = courseService.findAll();
        return ResponseEntity.ok(courses);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(courseService.findById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<?> findByName(@PathVariable String name) {
        return ResponseEntity.ok(courseService.findByCourseName(name));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Course entity) {
        try {
            Course updatedCourse = courseService.update(entity);
            return ResponseEntity.ok(updatedCourse);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id) {
        courseService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
