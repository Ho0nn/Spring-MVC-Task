package com.book.springtask.services;

import com.book.springtask.entity.Instructor;
import com.book.springtask.entity.Student;
import com.book.springtask.repository.InstructorRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorService {

    @Autowired
    private InstructorRepo insRepo;

    public Instructor insert(Instructor ins) {
        return insRepo.save(ins);
    }

    public List<Instructor> findByName(String name) {
        return insRepo.findByName(name);
    }

    public Optional<Instructor> findById(Integer id) {
        return insRepo.findById(id);
    }

    public List<Instructor> findAll() {
        return insRepo.findAll();
    }

    public Instructor update(Instructor ins) {
        Optional<Instructor> curOpt = insRepo.findById(ins.getId());
        if (curOpt.isPresent()) {
            Instructor cur = curOpt.get();
            cur.setName(ins.getName());
            return insRepo.save(cur);
        } else {
            return null;
        }
    }
    public void deleteById(Integer id) {
        insRepo.deleteById(id);
    }
}
