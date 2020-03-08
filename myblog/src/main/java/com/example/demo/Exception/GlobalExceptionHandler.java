package com.example.demo.Exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 实现全局异常捕捉
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map<String,Object> exceptionHandler(Exception e){
        log.error("捕获异常"+e.getMessage());
        e.printStackTrace();
        Map map = new HashMap<String,Object>();
        map.put("捕获异常：",e.getMessage());
        return map;
    }

}
