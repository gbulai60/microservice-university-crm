package com.university.teacherservice.dao;
import com.university.teacherservice.entity.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TeacherRepository extends JpaRepository<Teacher, String>, JpaSpecificationExecutor<Teacher> {
Page<Teacher> findAll(Pageable pageable);
Page<Teacher> findAll(Specification<Teacher> specification, Pageable pageable);
}

