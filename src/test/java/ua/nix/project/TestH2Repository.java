package ua.nix.project;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.nix.project.repository.entity.StudentEntity;

public interface TestH2Repository extends JpaRepository<StudentEntity, Long> {
}
