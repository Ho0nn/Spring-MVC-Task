package com.book.springtask.services;

import com.book.springtask.entity.Student;
import com.book.springtask.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    public Student insert(Student student) {
        return studentRepo.save(student);
    }

    public List<Student> findByName(String name) {
        return studentRepo.findByName(name);
    }

    public Optional<Student> findById(Integer id) {
        return studentRepo.findById(id);
    }

    public List<Student> findAll() {
        return studentRepo.findAll();
    }

    public Student update(Student st) {
        Optional<Student> curOpt = studentRepo.findById(st.getId());
        if (curOpt.isPresent()) {
            Student cur = curOpt.get();
            cur.setName(st.getName());
            cur.setEmail(st.getEmail());
            return studentRepo.save(cur);
        } else {
            return null;
        }
    }
    public void deleteById(Integer id) {
        studentRepo.deleteById(id);
    }
}
