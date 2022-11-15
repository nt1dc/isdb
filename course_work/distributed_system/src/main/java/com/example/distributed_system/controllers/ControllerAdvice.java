package com.example.distributed_system.controllers;

import com.example.distributed_system.exceptions.GameOverException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(assignableTypes = {WorldController.class})
public class ControllerAdvice {
    @ExceptionHandler(GameOverException.class)
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    public String handleNotFoundException(GameOverException e) {
        return "GAME OVER ";
    }

}
