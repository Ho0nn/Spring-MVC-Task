package com.book.springtask.services;

import com.book.springtask.entity.Course;
import com.book.springtask.entity.Instructor;
import com.book.springtask.repository.CourseRepo;
import com.book.springtask.repository.InstructorRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    private InstructorRepo instructorRepo;

    public void insert(Course course, Integer instructorId) {

        Instructor instructor = instructorRepo.findById(instructorId)
                .orElseThrow(() -> new EntityNotFoundException("Instructor not found with ID: " + instructorId));
        course.setInstructor(instructor);
        courseRepo.save(course);
    }

    public List<Course> findByCourseName(String name) {
        return courseRepo.findByName(name);
    }

    public Optional<Course> findById(Integer id) {
        return courseRepo.findById(id);
    }

    public List<Course> findAll() {
        return courseRepo.findAll();
    }

    public Course update(Course c) {
        Optional<Course> curOpt = courseRepo.findById(c.getId());
        if (curOpt.isPresent()) {
            Course cur = curOpt.get();
            cur.setName(c.getName());
            cur.setInstructor(c.getInstructor());
            return courseRepo.save(cur);
        } else {
            throw new IllegalArgumentException("Course with ID " + c.getId() + " not found");
        }
    }

    public void deleteById(Integer id) {
        courseRepo.deleteById(id);
    }
}
