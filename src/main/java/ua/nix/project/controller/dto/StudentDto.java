package ua.nix.project.controller.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.nix.project.repository.entity.PhotoEntity;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    private String name;
    private String email;
    @JsonBackReference
    private List<PhotoEntity> photos;

}
