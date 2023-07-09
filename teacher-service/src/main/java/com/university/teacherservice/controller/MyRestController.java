package com.university.teacherservice.controller;


import com.university.teacherservice.entity.Teacher;
import com.university.teacherservice.service.TeacherService;
import com.university.teacherservice.specification.TeachertSpecifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import java.util.Set;


@RestController
@RequestMapping("/api")
public class MyRestController {

    @Autowired
    TeacherService teacherService;

    @GetMapping("/teachers")
    @ResponseStatus(HttpStatus.OK)
    public Page<Teacher> findPaginated(@RequestParam("page") Optional<Integer> page,
                                       @RequestParam("size") Optional<Integer> size,
                                       @RequestParam("courseId") Optional<Integer> courseId,
                                        @RequestParam("idnp") Optional<String> idnp)
    {Specification<Teacher> specification= TeachertSpecifications.createSpecification(courseId.orElse(null),idnp.orElse(" "));

        return teacherService.list(specification,PageRequest.of(page.orElse(0), size.orElse(20)));
    }
//    @GetMapping("/students/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public Teacher getStudentById(@PathVariable String id) {return teacherService.get(id);}
//    @GetMapping("/groups")
//    @ResponseStatus(HttpStatus.OK)
//    public List<Group> getAllGrupe(){return grupaService.getAll();}
    @PostMapping("/teachers")
    @ResponseStatus(HttpStatus.CREATED)
    public Teacher save(@RequestBody Teacher teacher){
        return teacherService.save(teacher);

    }
//    @PutMapping("/students")
//    @ResponseStatus(HttpStatus.OK)
//    public Teacher updateStudent(@RequestBody Teacher student){
//        return teacherService.save(student);}
//    @DeleteMapping("/students/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void deleteStudent(@PathVariable("id") String id){
//         teacherService.delete(id);
//    }
//
//    @PostMapping("/groups")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Group saveGrupa(@RequestBody Group group){
//        return grupaService.save(group);
//    }

}
