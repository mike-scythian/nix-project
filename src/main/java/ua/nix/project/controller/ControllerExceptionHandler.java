package ua.nix.project.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import ua.nix.project.exception.StudentNotFound;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ResponseStatus(value = HttpStatus.I_AM_A_TEAPOT, reason = "Student not found")
    @ExceptionHandler(StudentNotFound.class)
    public void handlerException(StudentNotFound e){
        e.getMessage();
    }

}
