package com.book.springtask.repository;

import com.book.springtask.entity.Instructor;
import com.book.springtask.entity.Quiz;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface QuizRepo extends JpaRepository<Quiz,Integer>{
    List<Quiz> findByCourseName(String name);
    Optional<Quiz> findById(Integer id);
    List<Quiz> findAll();

}
