package ua.nix.project.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.nix.project.exception.StudentNotFound;
import ua.nix.project.controller.dto.StudentDto;
import ua.nix.project.service.StudentService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {


    private final StudentService studentService;

    @GetMapping("/students")
    public ResponseEntity<List<StudentDto>> students() {

        return new ResponseEntity<>(studentService.getStudents(), HttpStatus.CREATED);
    }
    @GetMapping("/students/{id}")
    public ResponseEntity<StudentDto> getStudent(@PathVariable("id") long studentId){

        StudentDto studentDto = studentService.findStudent(studentId);

        return new ResponseEntity<>(studentDto, HttpStatus.FOUND);

    }

    @PostMapping("/students")
    public ResponseEntity<Void> createStudent(@RequestBody StudentDto studentDto) {

        studentService.createStudent(studentDto.getName(), studentDto.getEmail());

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping("/students/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable("id") long studentId,
                                                    @RequestBody StudentDto newStudent) {

        return new ResponseEntity<>(studentService.updateStudent(studentId, newStudent), HttpStatus.CREATED);
    }

    @DeleteMapping("students/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable("id") long studentId){

        studentService.deleteStudent(studentId);

        return new ResponseEntity<>(HttpStatus.OK);
    }



}
