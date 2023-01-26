package ua.nix.project.repository.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Setter
@Getter
@Table(name = "student", schema = "nix")
public class StudentEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column
  private long id;

  @Column
  private String name;

  @Column
  private String email;

  @OneToMany(mappedBy = "student")
  private Set<PhotoEntity> photos;

}
