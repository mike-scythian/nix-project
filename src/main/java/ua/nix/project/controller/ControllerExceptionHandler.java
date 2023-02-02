package ua.nix.project.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import ua.nix.project.controller.dto.ErrorDto;
import ua.nix.project.exception.StudentNotFound;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Student not found")
    @ExceptionHandler(StudentNotFound.class)
    public ResponseEntity<ErrorDto> handlerException(StudentNotFound e){

        ErrorDto error = new ErrorDto( e.getMessage() );

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

}
