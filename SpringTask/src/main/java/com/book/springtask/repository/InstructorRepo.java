package com.book.springtask.repository;

import com.book.springtask.entity.Instructor;
import com.book.springtask.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface InstructorRepo extends JpaRepository<Instructor,Integer>{
    List<Instructor> findByName(String name);
    Optional<Instructor> findById(Integer id);
    List<Instructor> findAll();

}
