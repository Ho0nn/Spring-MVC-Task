CREATE TABLE tech.instructors (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE tech.courses (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    instructor_id INT,
    FOREIGN KEY (instructor_id) REFERENCES tech.instructors(id) 
);

CREATE TABLE tech.quizzes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    instructor_id INT,
    cource_id INT,
    FOREIGN KEY (instructor_id) REFERENCES tech.instructors(id) ,
    FOREIGN KEY (cource_id) REFERENCES tech.courses(id)
);

CREATE TABLE tech.students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL
);

CREATE TABLE tech.student_courses (
    student_id INT,
    course_id INT,
    PRIMARY KEY (student_id, course_id),
    FOREIGN KEY (student_id) REFERENCES tech.students(id) ,
    FOREIGN KEY (course_id) REFERENCES tech.courses(id) ON DELETE CASCADE
);
CREATE TABLE tech.student_quizzes (
    student_id INT,
    quiz_id INT,
    PRIMARY KEY (student_id, quiz_id),
    FOREIGN KEY (student_id) REFERENCES tech.students(id) ,
    FOREIGN KEY (quiz_id) REFERENCES tech.quizzes(id)
);
