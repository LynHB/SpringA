package com.example.springboot.config;

import com.example.springboot.validate.entity.RspDTO;
import lombok.extern.slf4j.Slf4j;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.validation.ConstraintViolationException;
import java.util.Objects;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    private static int DUPLICATE_KEY_CODE = 1001;
    private static int PARAM_FAIL_CODE = 1002;
    private static int VALIDATION_CODE = 1003;

    /*
        方法参数异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public RspDTO handleRRException(MethodArgumentNotValidException e) {
        log.info(e.getMessage(), e);

        return new RspDTO(PARAM_FAIL_CODE, Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage());
    }

    /*
        参数验证失败
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public RspDTO handleRRException(ConstraintViolationException e){
        log.info(e.getMessage(),e);
        return new RspDTO(VALIDATION_CODE,e.getCause().getMessage());
    }

    /*
        路径不存在
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    public RspDTO handleRRException(NoHandlerFoundException e){
        log.info(e.getMessage(),e);
        return new RspDTO(404,e.getCause().getMessage());
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public RspDTO handleRRException(HttpRequestMethodNotSupportedException e){
        log.info(e.getMessage());
        return new RspDTO(400,e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public RspDTO handleRRException(Exception e){
        log.info(e.getMessage(),e);
        return new RspDTO(500,e.getMessage());
    }


}
