package com.book.springtask.repository;

import com.book.springtask.base.BaseRepo;
import com.book.springtask.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface StudentRepo extends BaseRepo<Student,Integer> {
    List<Student> findByName(String name);
    Optional<Student> findById(Integer id);
    List<Student> findAll();
    Optional<Student>findByEmail(String email);

}
