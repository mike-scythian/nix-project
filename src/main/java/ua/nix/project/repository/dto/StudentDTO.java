package ua.nix.project.repository.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.nix.project.custom.mapper.CustomMapper;
import ua.nix.project.repository.entity.PhotoEntity;
import ua.nix.project.repository.entity.StudentEntity;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO implements CustomMapper<StudentDTO, StudentEntity> {
    private String name;
    private String email;
    @JsonBackReference
    private List<PhotoEntity> photos;

    @Override
    public StudentDTO toMap(StudentEntity entity) {
        if(entity == null)
            return new StudentDTO();
        if(entity.getPhotos().isEmpty())
            this.photos = List.of();
        else
            this.photos = entity.getPhotos();
        this.name = entity.getName();
        this.email = entity.getEmail();

        return this;
    }
}
