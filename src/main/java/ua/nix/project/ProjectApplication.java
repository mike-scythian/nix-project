package ua.nix.project;

import java.util.Arrays;
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
/*

  @Bean
  public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
    return args -> {

      System.out.println("Let's inspect the beans provided by Spring Boot:");

      String[] beanNames = ctx.getBeanDefinitionNames();
      Arrays.sort(beanNames);
      for (String beanName : beanNames) {
        System.out.println(beanName);
      }

      //studentService.createStudent("Mark", "mark1234@gmail.com");
      //studentService.createStudent("Tom", "jerry@gmail.com");

      //create photos

      /*photoService.createPhoto("url1","image1", 10L);
      photoService.createPhoto("url2","image2", 9L);
      photoService.createPhoto("url3","image3", 9L);

      photoService.getPhotoByDescription("image2").forEach( ph -> System.out.println(ph.getUrl()));

    };
  }
*/
}
