package ua.nix.project.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.nix.project.exception.StudentNotFound;
import ua.nix.project.repository.dto.StudentDTO;
import ua.nix.project.service.StudentService;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public ResponseEntity<List<StudentDTO>> students() {

        return ResponseEntity.ok(studentService.getStudents());
    }
    @GetMapping("/students/{id}")
    public ResponseEntity<StudentDTO> getStudent(@PathVariable("id") long studentId) throws StudentNotFound {

        StudentDTO studentDTO = studentService.findStudent(studentId).orElseThrow(StudentNotFound::new);

        return ResponseEntity.ok(studentDTO);

    }

    @PostMapping("/students")
    public ResponseEntity<Long> createStudent(@RequestBody StudentDTO studentDTO) {

        studentService.createStudent(studentDTO.getName(), studentDTO.getEmail());
        return ResponseEntity.ok().build();
    }
    @PutMapping("/students/{id}")
    public ResponseEntity<StudentDTO> updateStudent(@PathVariable("id") long studentId,
                                                    @RequestBody StudentDTO newStudent) throws StudentNotFound {

        return ResponseEntity.ok(studentService.updateStudent(studentId, newStudent));
    }

    @DeleteMapping("students/{id}")
    public ResponseEntity deleteStudent(@PathVariable("id") long studentId){
        studentService.deleteStudent(studentId);

        return ResponseEntity.ok().build();
    }



}
