package ua.nix.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.nix.project.repository.entity.PhotoEntity;

import java.util.Optional;
import java.util.Set;

public interface PhotoRepository extends JpaRepository<PhotoEntity, Long> {

    Optional<Set<PhotoEntity>> findByDescription(String description);
}