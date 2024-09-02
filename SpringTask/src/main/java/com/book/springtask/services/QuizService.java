package com.book.springtask.services;

import com.book.springtask.entity.Instructor;
import com.book.springtask.entity.Quiz;
import com.book.springtask.repository.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    private QuizRepo quizRepo;

    public Quiz insert(Quiz quiz) {
        return quizRepo.save(quiz);
    }

    public List<Quiz> findByCourseName(String name) {
        return quizRepo.findByCourseName(name);
    }

    public Optional<Quiz> findById(Integer id) {
        return quizRepo.findById(id);
    }

    public List<Quiz> findAll() {
        return quizRepo.findAll();
    }

    public Quiz update(Quiz quiz) {
        Optional<Quiz> curOpt = quizRepo.findById(quiz.getId());
        if (curOpt.isPresent()) {
            Quiz cur = curOpt.get();
            cur.setTitle(quiz.getTitle());
            cur.setCourse(quiz.getCourse());
            cur.setInstructor(quiz.getInstructor());
            return quizRepo.save(cur);
        } else {
            return null;
        }
    }
    public void deleteById(Integer id) {
        quizRepo.deleteById(id);
    }
}
