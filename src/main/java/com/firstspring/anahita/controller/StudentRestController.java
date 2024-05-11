package com.firstspring.anahita.controller;

import com.firstspring.anahita.Student;
import com.firstspring.anahita.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/student")
public class StudentRestController {

    @Autowired
    @Qualifier("studentServiceImpl")
    private StudentService studentService;

    @PostMapping(path = "/save")
    public ResponseEntity<Student> save(@RequestBody Student student) {
        Student save = studentService.save(student);
        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }

    @GetMapping("/find-by-id")
    public ResponseEntity<Student> findById(@RequestParam Long id) {
        try {
            Student byId = studentService.findById(id);
            return new ResponseEntity<>(byId, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/find-all")
    public ResponseEntity<List<Student>> findAll() {
        List<Student> all = studentService.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }
}
