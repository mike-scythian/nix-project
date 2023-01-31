package ua.nix.project.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ua.nix.project.repository.dto.PhotoDTO;
import ua.nix.project.repository.entity.PhotoEntity;

@Mapper
public interface PhotoMapper {
    PhotoMapper INSTANCE = Mappers.getMapper(PhotoMapper.class);

    PhotoDTO toMap(PhotoEntity photo);
}
