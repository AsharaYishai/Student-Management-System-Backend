package org.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.student.entity.StudentEntity;
import org.student.service.StudentService;

public interface StudentRepository extends JpaRepository<StudentEntity,Long> {

    StudentEntity findByFirstName(String firstName);
}
