package com.example.finalpro.dtos;

import com.example.finalpro.models.Colleges;
import com.example.finalpro.models.Lessons;
import com.example.finalpro.models.Students;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class StudentDto {
    private int id;
    private Colleges college;
    private String studentNumber;
    private String name;
    private String family;
    private String nationalCode;
    private String address;
    private List<Lessons> lessons;
    private Float avg;
    public Students convertDtotoEntity(StudentDto studentDto){
        Students student = new Students();
        student.setName(studentDto.getName());
        student.setFamily(studentDto.getFamily());
        student.setNationalCode(studentDto.getNationalCode());
        student.setAddress(studentDto.getAddress());
        student.setCollege(studentDto.getCollege());
        student.setAvg(studentDto.getAvg());
        student.setStudentNumber(studentDto.getStudentNumber());
        student.setLessons(studentDto.getLessons());
        return student;
    }
}
