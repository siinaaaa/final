package com.example.finalpro.dtos;

import com.example.finalpro.models.Colleges;
import com.example.finalpro.models.Lessons;
import com.example.finalpro.models.Teachers;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class TeacherDto {
    private int id;
    private Colleges college;
    private String personalyCode;
    private String name;
    private String family;
    private String nationalCode;
    private List<Lessons> lessons;

    public Teachers convertDtotoEntity(TeacherDto teacherDto){
        Teachers teacher = new Teachers();
        teacher.setCollege(teacherDto.getCollege());
        teacher.setFamily(teacherDto.getFamily());
        teacher.setName(teacherDto.getName());
        teacher.setPersonalyCode(teacherDto.getPersonalyCode());
        teacher.setLessons(teacherDto.getLessons());
        teacher.setNationalCode(teacherDto.getNationalCode());
        return teacher;
    }


}
