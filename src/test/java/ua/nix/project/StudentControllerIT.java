package ua.nix.project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;
import ua.nix.project.controller.dto.StudentDto;

import java.util.Collections;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class StudentControllerIT {

    @LocalServerPort
    private int port;

    private String baseUrl = "http://localhost";

    private WebTestClient testClient;

    @Autowired
    private TestH2Repository testRepository;

    @BeforeEach
    void setUpUrl() {
        baseUrl = baseUrl
                .concat(":")
                .concat(port + "")
                .concat("/students");

        testClient = WebTestClient
                .bindToServer()
                .baseUrl(baseUrl)
                .build();
    }

    @Test
    void shouldCreateNewStudent() {

        StudentDto student = new StudentDto("Mary", "marymail@gmail.com", Collections.emptyList());

        testClient
                .post()
                .uri(baseUrl)
                .body(Mono.just(student), StudentDto.class)
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.CREATED)
                .expectBody().jsonPath("name").isEqualTo("Mary");
    }

    @Test
    @Sql(statements = "INSERT INTO nix.student(id,email,name)VALUES(10, 'testmail@gmail.com', 'Molly Fisher')",
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(statements = "DELETE FROM nix.student WHERE id=10",
            executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void shouldGetAllStudents() {

        testClient
                .get()
                .uri(baseUrl)
                .exchange()
                .expectStatus().is2xxSuccessful()
                .expectBodyList(StudentDto.class).hasSize(1);
    }

    @Test
    @Sql(statements = "INSERT INTO nix.student(id,email,name)VALUES(10, 'testmail@gmail.com', 'Molly Fisher')",
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(statements = "DELETE FROM nix.student WHERE id=10",
            executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void shouldReturnStudentId() {

        testClient
                .get()
                .uri(baseUrl + "/10")
                .exchange()
                .expectStatus().is2xxSuccessful()
                .expectBody().jsonPath("email").isEqualTo("testmail@gmail.com")
                .jsonPath("name").isEqualTo("Molly Fisher");
    }

    @Test
    @Sql(statements = "INSERT INTO nix.student(id,email,name)VALUES(10, 'testmail@gmail.com', 'Molly Fisher')",
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(statements = "DELETE FROM nix.student WHERE id=10",
            executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void shouldUpdateStudentInfo() {

        StudentDto student = new StudentDto("Mary", "marymail@gmail.com", Collections.emptyList());

        testClient
                .put()
                .uri(baseUrl + "/10")
                .body(Mono.just(student), StudentDto.class)
                .exchange()
                .expectStatus().is2xxSuccessful()
                .expectBody().jsonPath("name").isEqualTo("Mary");
    }

    @Test
    @Sql(statements = "INSERT INTO nix.student(id,email,name)VALUES(10, 'testmail@gmail.com', 'Molly Fisher')",
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    void shouldDeleteStudentFromDatabase() {

        testClient
                .delete()
                .uri(baseUrl + "/10")
                .exchange()
                .expectStatus().isOk();
    }

}
