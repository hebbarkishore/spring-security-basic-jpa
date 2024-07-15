package com.security.spring.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * 
 * @author Kishore Hebbar
 *
 */ 

@ControllerAdvice
@RestController
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler({AccessDeniedException.class})
    public final ResponseEntity<String> handleAccessDeniedException(AccessDeniedException ex, WebRequest request) {
        return new ResponseEntity<String>("Access Is Denied ",HttpStatus.FORBIDDEN);
    }
    
    @org.springframework.web.bind.annotation.ExceptionHandler({ApplicationException.class})
    public final ResponseEntity<String> applicationException(ApplicationException ex, WebRequest request) {
        return new ResponseEntity<String>("Error is:"+ex.getMessage() ,HttpStatus.BAD_REQUEST);
    }

}
