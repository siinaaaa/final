package com.example.finalpro.models;

import com.example.finalpro.dtos.StudentDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table
@Data
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = true)

    private int id;
    @ManyToOne
    @JsonIgnore
    private Colleges college;
    @Column(unique = true)
    private String studentNumber;
    @Size(max = 48)
    private String name;
    @Size(max = 48)
    private String family;
    private String nationalCode;
    private String address;
    @OneToMany(mappedBy = "student")
    private List<Lessons>lessons;
    private Float avg;

    public StudentDto convertEntitytoDto(Students student){
        StudentDto studentDto = new StudentDto();
        studentDto.setStudentNumber(student.getStudentNumber());
        studentDto.setAvg(student.getAvg());
        studentDto.setFamily(student.getFamily());
        studentDto.setCollege(student.getCollege());
        studentDto.setAddress(studentDto.getAddress());
        studentDto.setLessons(student.getLessons());
        studentDto.setName(student.getName());
        studentDto.setNationalCode(student.getNationalCode());
        return studentDto;
    }

}
