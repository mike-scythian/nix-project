package ua.nix.project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.nix.project.exception.StudentNotFound;
import ua.nix.project.repository.StudentRepository;
import ua.nix.project.repository.dto.StudentDTO;
import ua.nix.project.repository.entity.StudentEntity;
import ua.nix.project.repository.mapper.StudentMapper;

import java.util.List;
import java.util.Optional;

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
  public StudentDTO updateStudent(long id, StudentDTO newStudent) throws StudentNotFound{
    StudentEntity student = studentRepository.findById(id).orElseThrow(StudentNotFound::new);

    student.setName(newStudent.getName());
    student.setEmail(newStudent.getEmail());

    //return StudentMapper.INSTANCE.toMap(studentRepository.save(student));

    return new StudentDTO().toMap(studentRepository.save(student));
  }
  public Optional<StudentDTO> findStudent(long id) {

    return studentRepository.findById(id).map(st -> new StudentDTO().toMap(st));
  }
  public List<StudentDTO> getStudents(){

    return studentRepository.findAll().stream()
            .map(s -> new StudentDTO().toMap(s))
            .toList();
  }

  public void deleteStudent(long id){

    studentRepository.deleteById(id);
  }

}
