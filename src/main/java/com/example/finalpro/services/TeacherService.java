package com.example.finalpro.services;

import com.example.finalpro.models.Teachers;
import com.example.finalpro.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
    private TeacherRepository teacherRepository;
    @Autowired
    public TeacherService(TeacherRepository teacherRepository){
        this.teacherRepository=teacherRepository;
    }
    public Teachers save(Teachers teachers){
        return this.teacherRepository.save(teachers);
    }
    public Teachers findByname(String name){
        return this.teacherRepository.findByName(name);
    }
    public String delete(int id){
         this.teacherRepository.deleteById(id);
         return "";

    }
}
