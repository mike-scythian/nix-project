CREATE TABLE IF NOT EXISTS nix.photo(
                          id SERIAL NOT NULL PRIMARY KEY,
                          url VARCHAR(255) NOT NULL,
                          student_id BIGINT NOT NULL,
                          FOREIGN KEY (student_id) REFERENCES nix.student(id)
);