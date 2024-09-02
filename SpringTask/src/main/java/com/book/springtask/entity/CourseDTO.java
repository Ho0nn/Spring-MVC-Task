package com.book.springtask.entity;

public class CourseDTO {
    private String name;
    private Integer instructorId;
    public Course toEntity() {
        Course course = new Course();
        course.setName(this.name);
        return course;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(Integer instructorId) {
        this.instructorId = instructorId;
    }
}
