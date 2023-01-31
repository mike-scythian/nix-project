package ua.nix.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.nix.project.repository.entity.PhotoEntity;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface PhotoRepository extends JpaRepository<PhotoEntity, Long> {

    List<PhotoEntity> findByDescription(String description);
}