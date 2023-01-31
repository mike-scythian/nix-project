package ua.nix.project.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ua.nix.project.repository.dto.StudentDTO;
import ua.nix.project.repository.entity.StudentEntity;


@Mapper(uses = {PhotoMapper.class})
public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    StudentDTO toMap(StudentEntity student);
}
