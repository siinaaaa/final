package com.example.finalpro.services;

import com.example.finalpro.models.Students;
import com.example.finalpro.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }
    public Students save(Students students){
        return this.studentRepository.save(students);

    }
}
