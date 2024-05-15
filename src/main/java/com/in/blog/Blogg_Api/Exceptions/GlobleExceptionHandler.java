package com.in.blog.Blogg_Api.Exceptions;

import com.in.blog.Blogg_Api.Payloads.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobleExceptionHandler {
    @ExceptionHandler(ResourcesNotFoundExecption.class)
    public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourcesNotFoundExecption ex){
        String massage =ex.getMessage();
        ApiResponse apiResponse=new ApiResponse(massage,false);
        return new ResponseEntity<ApiResponse>(apiResponse ,HttpStatus.NOT_FOUND);}
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleMethodArgsNotValidException(MethodArgumentNotValidException ex)
    {
        Map<String, String> rsp=new HashMap<>();
        //to get all error  validation
        ex.getBindingResult().getAllErrors().forEach((error)-> {
           String fieldName= ((FieldError)error).getField();
           String massage=error.getDefaultMessage();
           rsp.put(fieldName,massage);
        });
        return new ResponseEntity<Map<String,String>>(rsp,HttpStatus.BAD_REQUEST);


    }

}
