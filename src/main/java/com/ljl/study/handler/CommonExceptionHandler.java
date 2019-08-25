package com.ljl.study.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Map<String,Object> handlerException(Exception e){
        Map<String,Object> result = new HashMap<>();
        result.put("result", false);
        result.put("content", false);
        result.put("msg", e.getMessage());
        return result;
    }
}
