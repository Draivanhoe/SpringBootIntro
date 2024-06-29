package com.esercizio12.esercizio12;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public void create(Student toCreate) {
        this.studentRepository.saveAndFlush(toCreate);
    }

    public void updateWorkingStatus(Long id, boolean working) {
        Optional<Student> studentFound = studentRepository.findById(id);
        if (studentFound.isPresent()) {
            studentFound.get().setWorking(working);
            studentRepository.saveAndFlush(studentFound.get());
        }
    }

}