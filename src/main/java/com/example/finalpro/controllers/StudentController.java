package com.example.finalpro.controllers;

import com.example.finalpro.dtos.StudentDto;
import com.example.finalpro.models.Students;
import com.example.finalpro.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = "saveStudent")
    public String save(@RequestBody StudentDto studentDto) {
        this.studentService.save(studentDto.convertDtotoEntity(studentDto));
        return "saved";


    }

    @GetMapping(value = "readStudent")
    public StudentDto read(@RequestParam String name) {
        Students student = this.studentService.findByname(name);
        return student.convertEntitytoDto(student);


    }

    @GetMapping(value = "update")
    public String update(@RequestBody StudentDto studentDto) {
        this.studentService.delete(studentDto.getId());
        this.studentService.save(studentDto.convertDtotoEntity(studentDto));
        return "updated";
    }

    @GetMapping(value = "deleteStudent")
    public String delete(@RequestParam String name) {
        this.studentService.delete(this.studentService.findByname(name).getId());
        return "deleted";
    }
}
