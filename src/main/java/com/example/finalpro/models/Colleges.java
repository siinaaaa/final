package com.example.finalpro.models;


import com.example.finalpro.dtos.CollegeDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table
@Data
public class Colleges {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = true)

    private int id;
    @Column(unique = true)
    @Size(max = 48, min = 5)
    private String name;
    @OneToOne
    private Teachers manager;
    @OneToMany(mappedBy = "college")

    private List<Teachers>teachers;
    @OneToMany(mappedBy = "college")

    private List<Students>students;
    @OneToMany(mappedBy = "college")
    private List<Lessons>lessons;
    public CollegeDto convertEntitytoDto(Colleges college){
        CollegeDto collegeDto = new CollegeDto();
        collegeDto.setName(college.getName());
        collegeDto.setManager(college.getManager());
        collegeDto.setLessons(college.getLessons());
        collegeDto.setStudents(college.getStudents());
        collegeDto.setTeachers(college.getTeachers());
        return collegeDto;
    }


}
