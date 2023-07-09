package com.university.teacherservice.service;

import com.university.teacherservice.entity.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface TeacherService {
    public Teacher get(String Idnp);
    public Teacher save(Teacher teacher);
    public void delete(String id);
    Page<Teacher> list(Specification<Teacher> specification, Pageable pageable);
    Page<Teacher> list(Pageable pageable);


}
