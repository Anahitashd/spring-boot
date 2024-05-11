package com.firstspring.anahita.service.impl;

import com.firstspring.anahita.Student;
import com.firstspring.anahita.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentMemServiceImpl implements StudentService {

    private List<Student> students = new ArrayList<Student>();
    @Override
    public Student save(Student student) {
        students.add(student);
        return student;
    }

    @Override
    public Student findById(Long id) {
        return null;
    }

    @Override
    public List<Student> getAll() {
        return List.of();
    }
}
