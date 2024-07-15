package com.example.finalpro.dtos;

import com.example.finalpro.models.Colleges;
import com.example.finalpro.models.Lessons;
import com.example.finalpro.models.Students;
import com.example.finalpro.models.Teachers;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class LessonDto {
    private int id;
    private Teachers teacher;
    private Students student;
    private Colleges college;
    private String name;
    private int unit;

    public Lessons convertDtotoEntity(LessonDto lessonDto){
        Lessons lesson = new Lessons();
        lesson.setName(lessonDto.getName());
        lesson.setUnit(lessonDto.getUnit());
        lesson.setCollege(lessonDto.getCollege());
        lesson.setTeacher(lessonDto.getTeacher());
        lesson.setStudent(lessonDto.getStudent());
        return lesson;

    }


}
