package com.firstspring.anahita.service.impl;

import com.firstspring.anahita.Student;
import com.firstspring.anahita.repository.StudentRepository;
import com.firstspring.anahita.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student save(Student student) {
        Student byNationalCode = studentRepository.findByNationalCode(student.getNationalCode());
        if(Objects.nonNull(byNationalCode))
            throw new RuntimeException("National Code already exists");

        return studentRepository.save(student);
    }

    public Student findById(Long id) {
        return studentRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public List<Student> getAll() {
        return studentRepository.findAll();
    }
}
