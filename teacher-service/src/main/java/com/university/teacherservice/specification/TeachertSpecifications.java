package com.university.teacherservice.specification;


import com.university.teacherservice.entity.Teacher;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;


public class TeachertSpecifications {

    public static Specification<Teacher> createSpecification( Integer courseId,String  idnp) {
        return (Root<Teacher> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.conjunction();

            if (courseId != null ) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.isMember(courseId,root.get("coursesId")));
            }
            if (idnp != null && !idnp.isEmpty()) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("id"), idnp));
            }

            return predicate;
        };
    }
}