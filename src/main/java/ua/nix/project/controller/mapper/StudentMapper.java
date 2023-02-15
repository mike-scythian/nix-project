package ua.nix.project.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ua.nix.project.controller.dto.StudentDto;
import ua.nix.project.repository.entity.StudentEntity;


@Mapper(uses = {PhotoMapper.class})
public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    StudentDto toMap(StudentEntity student);
    StudentEntity toEntityMap(StudentDto studentDto);
}
