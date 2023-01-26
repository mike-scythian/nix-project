package ua.nix.project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.nix.project.repository.PhotoRepository;
import ua.nix.project.repository.StudentRepository;
import ua.nix.project.repository.entity.PhotoEntity;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class PhotoService {

   // @Autowired
    private final PhotoRepository photoRepository;
   // @Autowired
    private final StudentRepository studentRepository;

    public void createPhoto(String photoUrl, String description, long studentId){
        PhotoEntity photo = new PhotoEntity();

        photo.setUrl(photoUrl);
        photo.setDescription(description);
        photo.setStudent(studentRepository.findById(studentId).orElseThrow());

        photoRepository.save(photo);
    }

    public Set<PhotoEntity> getPhotoByDescription(String description){

        return photoRepository.findByDescription(description).orElseThrow();
    }
}
