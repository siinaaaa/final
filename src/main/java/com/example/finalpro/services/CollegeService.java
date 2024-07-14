package com.example.finalpro.services;

import com.example.finalpro.models.Colleges;
import com.example.finalpro.repositories.CollegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollegeService {
    private CollegeRepository collegeRepository;
    @Autowired
    public CollegeService(CollegeRepository collegeRepository){
        this.collegeRepository=collegeRepository;
    }
    public Colleges save(Colleges college){
        return this.collegeRepository.save(college);
    }
    public Colleges findByname(String name){
        return this.collegeRepository.findByName(name);
    }
    public List<Colleges>colleges(){
        return this.collegeRepository.findAll();
    }
    public String delete(int id){
        this.collegeRepository.deleteById(id);
        return "true";
    }
}
