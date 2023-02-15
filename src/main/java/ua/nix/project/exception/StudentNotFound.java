package ua.nix.project.exception;

public class StudentNotFound extends RuntimeException{

    public StudentNotFound(){
        super("ERROR! Student not found");

    }
}
