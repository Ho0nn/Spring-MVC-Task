package com.book.springtask.services;

import com.book.springtask.base.BaseService;
import com.book.springtask.entity.Course;
import com.book.springtask.entity.Quiz;
import com.book.springtask.entity.Student;
import com.book.springtask.errors.DuplicateRecordException;
import com.book.springtask.repository.CourseRepo;
import com.book.springtask.repository.QuizRepo;
import com.book.springtask.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService extends BaseService<Student,Integer> {
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private CourseRepo courseRepo;
    @Autowired
    private QuizRepo quizRepo;
    public StudentService(StudentRepo studentRepo) {
        super(studentRepo);
        this.studentRepo=studentRepo;
    }
    @Override
    public Student insert(Student entity) {
        if(!entity.getEmail().isEmpty() && entity.getEmail()!=null){
            Optional<Student> student=findByEmail(entity.getEmail());
            if (student.isPresent()){
                throw new DuplicateRecordException("This email has been founded already !");
            }
        }
        return super.insert(entity);
    }


    private Optional<Student>findByEmail(String email){
        return studentRepo.findByEmail(email);
    }
    public List<Student> findByName(String name) {
        return studentRepo.findByName(name);
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

    public void enrollCourse(int studId, int courseId) {
        Student student = studentRepo.findById(studId)
                .orElseThrow(() -> new IllegalArgumentException("Student not found with ID: " + studId));
        Course course = courseRepo.findById(courseId)
                .orElseThrow(() -> new IllegalArgumentException("Course not found with ID: " + courseId));
        student.getCourses().add(course);
        studentRepo.save(student);
    }

    public Quiz enrollQuiz(int studentId, int quizId) {
        Student student = studentRepo.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("Student not found with ID: " + studentId));

        Quiz quiz = quizRepo.findById(quizId)
                .orElseThrow(() -> new IllegalArgumentException("Quiz not found with ID: " + quizId));
        boolean isEnrolledCourse = student.getCourses().contains(quiz.getCourse());
        if (!isEnrolledCourse)
            throw new IllegalArgumentException("Enroll in the course first to register for the quiz!");
        student.getQuizzes().add(quiz);
        studentRepo.save(student);
        return quiz;
    }


}
