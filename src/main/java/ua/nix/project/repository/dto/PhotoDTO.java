package ua.nix.project.repository.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.nix.project.custom.mapper.CustomMapper;
import ua.nix.project.repository.entity.PhotoEntity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PhotoDTO implements CustomMapper<PhotoDTO, PhotoEntity> {

    private long id;

    private String url;

    private String description;

    @Override
    public PhotoDTO toMap(PhotoEntity entity) {
        if(entity == null)
            return new PhotoDTO();

        return new PhotoDTO(entity.getId(), entity.getUrl(),entity.getDescription());
    }
}
