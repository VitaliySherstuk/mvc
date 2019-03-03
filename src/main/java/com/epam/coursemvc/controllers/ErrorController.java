package com.epam.coursemvc.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Arrays;


@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleMyException(Exception ex, Model model) {

        String exceptionMessage = ex.getMessage();
        model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.toString());
        model.addAttribute("message", exceptionMessage);
        model.addAttribute("stackTrace", Arrays.asList(ex.getStackTrace()).toString());
        return "errorPage";
    }
}
