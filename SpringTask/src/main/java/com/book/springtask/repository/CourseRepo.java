package com.book.springtask.repository;

import com.book.springtask.entity.Course;
import com.book.springtask.entity.Quiz;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface CourseRepo extends JpaRepository<Course,Integer>{
    List<Course> findByName(String name);
    Optional<Course> findById(Integer id);
    List<Course> findAll();

}
