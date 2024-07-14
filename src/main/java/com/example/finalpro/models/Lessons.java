package com.example.finalpro.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table
@Data
public class Lessons {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = true)

    private int id;

    @ManyToOne

    private Teachers teacher;
    @ManyToOne
    private Students student;
    @ManyToOne
    @JsonIgnore
    private Colleges college;
    @Size(max = 64)
    @Column(unique = true)
    private String name;
    private int unit;
    @OneToMany(mappedBy = "lesson")
    private List<Students>students;
}
