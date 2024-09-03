package com.book.springtask.services;

import com.book.springtask.entity.Course;
import com.book.springtask.entity.Quiz;
import com.book.springtask.repository.CourseRepo;
import com.book.springtask.repository.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    private QuizRepo quizRepo;
    @Autowired
    private CourseRepo courseRepo;


    public Quiz insert(Quiz quiz) {
        Course course = courseRepo.findById(quiz.getCourse().getId())
                .orElseThrow(() -> new IllegalArgumentException("Course not found with ID: " + quiz.getCourse().getId()));
        quiz.setCourse(course);
        quiz.setInstructor(course.getInstructor());
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
            Course course = courseRepo.findById(quiz.getCourse().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Course not found with ID: " + quiz.getCourse().getId()));
            cur.setCourse(course);
            cur.setInstructor(course.getInstructor());

            return quizRepo.save(cur);
        } else {
            return null;
        }
    }
    public void deleteById(Integer id) {
        quizRepo.deleteById(id);
    }
}
