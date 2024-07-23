package org.student.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.student.dto.Student;
import org.student.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/student-controller")
@RequiredArgsConstructor
@CrossOrigin
public class StudentController {
    final StudentService service;

    @PostMapping("add-student")
    @ResponseStatus(HttpStatus.CREATED)
    public void addStudent(@RequestBody Student student){
        service.addStudent(student);
    }

    @GetMapping("get-all")
    public List<Student> getAll(){
        return service.getAll();
    }

    @DeleteMapping("/delete-student/{id}")
    public String deleteStudent(@PathVariable Long id){
        service.deleteStudentById(id);
        return "Deleted";
    }

    @PutMapping("/update-student")
    public void updateStudent(@RequestBody Student student){
        service.updateStudent(student);
    }

    @GetMapping("/find-by-id/{id}")
    public Student findById(@PathVariable Long id){
        return service.findById(id);
    }

    @GetMapping("/find-by-firstName/{firstName}")
    public Student findByFirstName(@PathVariable String firstName){
        return service.findByFirstName(firstName);
    }



}
