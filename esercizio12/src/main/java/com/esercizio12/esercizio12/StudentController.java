package com.esercizio12.esercizio12;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired StudentRepository studentRepository;

    @PostMapping
    public void create(@RequestBody Student student) {
        studentRepository.save(student);
    }

    @GetMapping
    public List<Student> getAll() {
        List<Student> students = studentRepository.findAll();
        return students;
    }

    @GetMapping(path = "/{id}")
    public Student getById(@PathVariable Long id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            return student.get();
        } else {
            return null;
        }
    }

    @PutMapping(path = "/update/{id}")
    public void updateNameAndSurname(@PathVariable Long id,
                       @RequestBody Student updatedStudent) {
        Optional<Student> studentFound = studentRepository.findById(id);
        if (studentFound.isPresent()) {
            if (updatedStudent.getName() != null || !updatedStudent.getName().isEmpty()) {
                studentFound.get().setName(updatedStudent.getName());
            }

            if (updatedStudent.getSurname() != null || !updatedStudent.getSurname().isEmpty()) {
                studentFound.get().setSurname(updatedStudent.getSurname());
            }

            studentRepository.saveAndFlush(studentFound.get());
        }
    }

    @PatchMapping(path = "/{id}")
    public void updateWorkingStatus(@PathVariable Long id,
                                    @RequestParam boolean working) {
        studentService.updateWorkingStatus(id, working);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteById(@PathVariable Long id) {
        studentRepository.deleteById(id);
    }

}