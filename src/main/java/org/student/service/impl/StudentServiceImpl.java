package org.student.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.student.dto.Student;
import org.student.entity.StudentEntity;
import org.student.repository.StudentRepository;
import org.student.service.StudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    final StudentRepository repository;

    @Override
    public void addStudent(Student student) {
        StudentEntity studentEntity = new ObjectMapper().convertValue(student, StudentEntity.class);
        repository.save(studentEntity);
    }

    @Override
    public List<Student> getAll() {
        List<Student> studentList = new ArrayList<>();
        List<StudentEntity> allEntityList =  repository.findAll();
        allEntityList.forEach(entity ->{
            studentList.add(new ObjectMapper().convertValue(entity,Student.class));
        });
        return  studentList;
    }

    @Override
    public void deleteStudentById(Long id) {
        if(repository.existsById(id)){
            repository.deleteById(id);
        }
    }

    @Override
    public void updateStudent(Student student) {
        if(repository.findById(student.getId()).isPresent()){
            repository.save(new ObjectMapper().convertValue(student, StudentEntity.class));
        }
    }

    @Override
    public Student findById(Long id) {
        if (repository.findById(id).isPresent()) {
            Optional<StudentEntity> byId = repository.findById(id);
            return new ObjectMapper().convertValue(byId.get(), Student.class);
        }

        return new Student();

    }

    @Override
    public Student findByFirstName(String firstName) {
        return new ObjectMapper().convertValue(repository.findByFirstName(firstName), Student.class);
    }
}

