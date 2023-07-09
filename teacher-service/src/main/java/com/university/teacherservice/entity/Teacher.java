package com.university.teacherservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "teachers")
public class Teacher {
    @Id
    private String id;
    private int numStudents;
    @ElementCollection
    @CollectionTable(name = "teacher_courses", joinColumns = @JoinColumn(name = "teacher_id"))
    private HashMap<Integer,Integer> coursesId;





}
