package com.university.teacherservice.service;

import com.university.teacherservice.dao.TeacherRepository;
import com.university.teacherservice.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public Teacher get(String  id) {
        Teacher student=null;
        Optional<Teacher> optional= teacherRepository.findById(id);
        if(optional.isPresent()) student=optional.get();
        return student;
    }

    @Override
    public Teacher save(Teacher student) {
        return teacherRepository.save(student);
    }

    @Override
    public void delete(String id) {
        teacherRepository.deleteById(id);

    }

    @Override
    public Page<Teacher> list(Specification<Teacher> specification, Pageable pageable) {
        return teacherRepository.findAll(specification,pageable);
    }

    @Override
    public Page<Teacher> list(Pageable pageable) {
        return teacherRepository.findAll(pageable);
    }


}