package ua.nix.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import ua.nix.project.service.PhotoService;
import ua.nix.project.service.StudentService;

@SpringBootApplication
public class ProjectApplication {

  @Autowired
  private StudentService studentService;
  @Autowired
  private PhotoService photoService;

  public static void main(String[] args) {
    SpringApplication.run(ProjectApplication.class, args);
  }


  @Bean
  public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
    return args -> {

      //studentService.createStudent("Mike", "myemail@gmail.com");

    };
  }

}
