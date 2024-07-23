package org.student.service;

import org.student.dto.Student;

import java.util.List;

public interface StudentService {
    void addStudent(Student student);


    List<Student> getAll();

    void deleteStudentById(Long id);

    void updateStudent(Student student);

    Student findById(Long id);

    Student findByFirstName(String firstName);
}
