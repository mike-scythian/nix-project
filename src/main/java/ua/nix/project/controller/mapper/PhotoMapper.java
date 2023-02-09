package ua.nix.project.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ua.nix.project.controller.dto.PhotoDto;
import ua.nix.project.repository.entity.PhotoEntity;

@Mapper
public interface PhotoMapper {
    PhotoMapper INSTANCE = Mappers.getMapper(PhotoMapper.class);

    PhotoDto toMap(PhotoEntity photo);
    PhotoEntity toEntityMap(PhotoDto photoDto);
}
