package ua.nix.project.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.nix.project.controller.mapper.StudentMapper;
import ua.nix.project.exception.StudentNotFound;
import ua.nix.project.repository.StudentRepository;
import ua.nix.project.controller.dto.StudentDto;
import ua.nix.project.repository.entity.StudentEntity;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentDto createStudent(@NonNull String name, @NonNull String email) {

        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setName(name);
        studentEntity.setEmail(email);

        return StudentMapper.INSTANCE.toMap(studentRepository.save(studentEntity));
    }

    public StudentDto updateStudent(long id, StudentDto newStudent){

        StudentEntity student = studentRepository.findById(id)
                .orElseThrow(StudentNotFound::new);

        if (newStudent.getName() != null)
            student.setName(newStudent.getName());

        if (newStudent.getEmail() != null)
            student.setEmail(newStudent.getEmail());

        if(newStudent.getPhotos() == null)
            student.setPhotos(Collections.emptyList());
        else
            if(!newStudent.getPhotos().isEmpty())
                student.setPhotos(newStudent.getPhotos());

        return StudentMapper.INSTANCE.toMap(studentRepository.save(student));
    }

    public StudentDto findStudent(long id) {

        return StudentMapper.INSTANCE.toMap(studentRepository.findById(id)
                .orElseThrow(StudentNotFound::new));
    }

    public List<StudentDto> getStudents() {

        return studentRepository.findAll().stream()
                .map(StudentMapper.INSTANCE::toMap)
                .toList();
    }

    public void deleteStudent(long id) {

        if(studentRepository.existsById(id))
            studentRepository.deleteById(id);
        else
            throw new StudentNotFound();
    }

}
