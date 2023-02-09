package ua.nix.project;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ua.nix.project.controller.dto.StudentDto;
import ua.nix.project.controller.mapper.StudentMapper;
import ua.nix.project.repository.entity.StudentEntity;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;

class DtoMapperTest {

    private final StudentMapper studentMapper = StudentMapper.INSTANCE;

    private static StudentEntity studentEntity;
    private static StudentDto studentDto;

    @BeforeAll
    static void init(){
        studentEntity = new StudentEntity(1L, "John Doe", "testmail@gmail.com", Collections.emptyList());
        studentDto = new StudentDto("John Dto", "test_dto_mail@gmail.com", Collections.emptyList());
    }

    @Test
    void shouldCreateDtoFromEntity(){
        StudentDto localDto = studentMapper.toMap(studentEntity);

       assertAll(
               () -> assertThat(localDto.getName()).isEqualTo(studentEntity.getName()),
               () -> assertThat(localDto.getEmail()).isEqualTo(studentEntity.getEmail()),
               () -> assertThat(localDto.getPhotos()).containsAll(studentEntity.getPhotos())
       );
    }

    @Test
    void shouldConvertEntityFromDto(){

        StudentEntity localEntity = studentMapper.toEntityMap(studentDto);

        assertAll(
                () -> assertThat(localEntity.getName()).isEqualTo(studentDto.getName()),
                () -> assertThat(localEntity.getEmail()).isEqualTo(studentDto.getEmail()),
                () -> assertThat(localEntity.getPhotos()).containsAll(studentDto.getPhotos())
        );
    }
}
