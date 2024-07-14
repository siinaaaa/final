package com.example.finalpro.controllers;

import com.example.finalpro.models.Students;
import com.example.finalpro.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    private StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }
    @GetMapping(value = "save2")
    public String save(@RequestParam String name, @RequestParam String family, @RequestParam String nationalCode, @RequestParam String studentNumber, @RequestParam String address){
        Students students = new Students();
        students.setStudentNumber(studentNumber);
        students.setNationalCode(nationalCode);
        students.setFamily(family);
        students.setAddress(address);
        students.setName(name);
        studentService.save(students);
        return "ooo";

    }
}
