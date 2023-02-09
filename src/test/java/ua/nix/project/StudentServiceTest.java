package ua.nix.project;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ua.nix.project.controller.dto.StudentDto;
import ua.nix.project.controller.mapper.StudentMapper;
import ua.nix.project.exception.StudentNotFound;
import ua.nix.project.repository.StudentRepository;
import ua.nix.project.repository.entity.StudentEntity;
import ua.nix.project.service.StudentService;

import java.util.Collections;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    private static StudentEntity student;

    @BeforeAll
    static void setUpStudent() {

        student = new StudentEntity(1L, "John Doe", "testemail@gmail.com", Collections.emptyList());

    }

    @Test
    void shouldCreateNewStudentInDB() {

        when(studentRepository.save(any(StudentEntity.class))).thenReturn(student);

        var createdStudent = studentService.createStudent("John Doe", "testemail@gmail.com");

        assertThat(createdStudent).isNotNull();
        assertThat(createdStudent.getEmail()).isEqualTo("testemail@gmail.com");
        assertThat(createdStudent.getName()).isEqualTo("John Doe");
    }

    @Test
    void shouldUpdateStudentInfo() {

        StudentDto localStudent = new StudentDto("Test Student", "testemail@gmail.com", Collections.emptyList());

        when(studentRepository.findById(anyLong())).thenReturn(Optional.of(student));
        when(studentRepository.save(any(StudentEntity.class)))
                .thenReturn(StudentMapper.INSTANCE.toEntityMap(localStudent));

        assertAll(
                () -> assertThat(studentService.updateStudent(1L, localStudent)).isNotNull(),
                () -> assertThat(studentService.updateStudent(1L, localStudent).getName())
                        .isEqualTo("Test Student")
        );
    }

    @Test
    void shouldThrowNotFoundStudentException() {

        when(studentRepository.findById(10L)).thenThrow(StudentNotFound.class);

        assertThrows(StudentNotFound.class, () -> studentService.findStudent(10L));

    }
}
