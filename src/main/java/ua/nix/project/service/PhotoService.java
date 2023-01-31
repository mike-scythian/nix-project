package ua.nix.project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.nix.project.exception.StudentNotFound;
import ua.nix.project.repository.PhotoRepository;
import ua.nix.project.repository.StudentRepository;
import ua.nix.project.repository.entity.PhotoEntity;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PhotoService {

    private final PhotoRepository photoRepository;
    private final StudentRepository studentRepository;

    public long createPhoto(String photoUrl, String description, long studentId) throws StudentNotFound {
        PhotoEntity photo = new PhotoEntity();

        photo.setUrl(photoUrl);
        photo.setDescription(description);
        photo.setStudent(studentRepository.findById(studentId).orElseThrow(StudentNotFound::new));

        return photoRepository.save(photo).getId();
    }

    public List<PhotoEntity> getPhotoByDescription(String description){

        return photoRepository.findByDescription(description);
    }
}
