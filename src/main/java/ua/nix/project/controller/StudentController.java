package ua.nix.project.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ua.nix.project.repository.dto.StudentDTO;
import ua.nix.project.service.StudentService;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping(path = "/students")
    public ResponseEntity<List<StudentDTO>> students() {

        return ResponseEntity.ok(studentService.getStudents());
    }

    @PostMapping("/new-student")
    public ResponseEntity<Long> createStudent(@RequestBody StudentDTO studentDTO) {

        studentService.createStudent(studentDTO.getName(),studentDTO.getEmail());
        return ResponseEntity.ok().build();
    }


}
