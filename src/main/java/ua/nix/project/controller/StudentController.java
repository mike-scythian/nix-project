package ua.nix.project.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

        return new ResponseEntity<>(studentDto, HttpStatus.CREATED);

    }

    @PostMapping("/students")
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto) {

        StudentDto student = studentService.createStudent(studentDto.getName(), studentDto.getEmail());

        return new ResponseEntity<>(student,HttpStatus.CREATED);
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
