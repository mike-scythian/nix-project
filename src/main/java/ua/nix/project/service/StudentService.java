package ua.nix.project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.nix.project.repository.StudentRepository;
import ua.nix.project.repository.dto.StudentDTO;
import ua.nix.project.repository.entity.StudentEntity;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

  private final StudentRepository studentRepository;

  public void createStudent(String name, String email) {

    StudentEntity studentEntity = new StudentEntity();
    studentEntity.setName(name);
    studentEntity.setEmail(email);

    studentRepository.save(studentEntity);
  }
  public List<StudentDTO> getStudents(){

    return studentRepository.findAll().stream()
            .map(stu -> new StudentDTO(stu.getName(), stu.getEmail()))
            .toList();
  }

}
