package com.firstspring.anahita.service;

import com.firstspring.anahita.Student;

import java.util.List;

public interface StudentService {

    Student save(Student student);

    Student findById(Long id);

    List<Student> getAll();
}
