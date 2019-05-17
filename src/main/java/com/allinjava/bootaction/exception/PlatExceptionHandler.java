package com.allinjava.bootaction.exception;


import com.allinjava.bootaction.common.enums.ResultEnum;
import org.springframework.beans.TypeMismatchException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.*;

/**
 * 异常处理器
 * 自适应效果
 * 即浏览器访问时返回页面
 * postman请求时返回json数据
 * 主要转发到 /error 异常控制器
 * @author: yuhang
 * @date: 2018/9/1
 */
@ControllerAdvice
public class PlatExceptionHandler  {

    /**
     * 代码中抛出的自定义业务异常
     */
    @ExceptionHandler(BusinessException.class)
    public String businessHandle(BusinessException ex, HttpServletRequest request){
        Map<String,Object> map=new LinkedHashMap<>();
        map.put("code",ex.getErrorCode());
        map.put("msg",ex.getMsg());
        commonHandle(map,request);
        return "forward:/error";
    }

    /**
     * 参数类型异常
     */
    @ExceptionHandler(TypeMismatchException.class)
    public String businessHandle(TypeMismatchException ex, HttpServletRequest request){
        Map<String,Object> map=new LinkedHashMap<>();
        map.put("code", ResultEnum.BAD_REQUEST.getCode());
        map.put("msg","参数格式传递错误,参数:"+ex.getPropertyName()+",类型应该是："+ex.getRequiredType());
        commonHandle(map,request);
        return "forward:/error";
    }

    /**
     * form提交实体的校验出现的异常
     */
    @ExceptionHandler(BindException.class)
    public String bind(BindException e, HttpServletRequest request){
        Map<String,Object> map=new LinkedHashMap<>();
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        StringBuffer sb=new StringBuffer();
        for (FieldError fieldError : fieldErrors) {
            sb.append(fieldError.getDefaultMessage()).append("</br>");
        }
        map.put("code",ResultEnum.BAD_REQUEST.getCode());
        map.put("msg",sb.toString());
        commonHandle(map,request);
        return "forward:/error";
    }

    /**
     * 控制层方法参数的校验出现的异常
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public String bind(ConstraintViolationException e, HttpServletRequest request){
        Map<String,Object> map=new LinkedHashMap<>();
        StringBuffer sb=new StringBuffer();
        Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
        for (ConstraintViolation<?> constraintViolation : constraintViolations) {
            sb.append(constraintViolation.getMessage()).append("</br>");
        }
        map.put("code",ResultEnum.BAD_REQUEST.getCode());
        map.put("msg",sb.toString());
        commonHandle(map,request);
        return  "forward:/error";
    }

    /**
     * @RequestBody 注解的实体校验出现的异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String bind(MethodArgumentNotValidException e, HttpServletRequest request){
        Map<String,Object> map=new LinkedHashMap<>();
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        StringBuffer sb=new StringBuffer();
        for (FieldError fieldError : fieldErrors) {
            sb.append(fieldError.getDefaultMessage()).append("</br>");
        }
        map.put("code",ResultEnum.BAD_REQUEST.getCode());
        map.put("msg",sb.toString());
        commonHandle(map,request);
        return  "forward:/error";
    }

   /* @ExceptionHandler(DataAccessException.class)
    public String sqlException(DataAccessException ex, HttpServletRequest request){
        ex.printStackTrace();
        Map<String,Object> map=new LinkedHashMap<>();
        map.put("code",ResultEnum.SERVER_ERROR.getCode());
        map.put("msg","数据库异常");
        request.setAttribute("javax.servlet.error.status_code",ResultEnum.SERVER_ERROR.getCode());
        request.setAttribute("data",map);
        return "forward:/error";
    }*/

    @ExceptionHandler(Exception.class)
    public String exception(Exception ex, HttpServletRequest request){
        ex.printStackTrace();
        Map<String,Object> map=new LinkedHashMap<>();
        map.put("code",ResultEnum.SERVER_ERROR.getCode());
        map.put("msg","未知异常");
        commonHandle(map,request);
        return "forward:/error";
    }

    // 公共处理
    private void commonHandle(Map<String,Object> map ,HttpServletRequest request){
        request.setAttribute("javax.servlet.error.status_code",ResultEnum.SERVER_ERROR.getCode());
        request.setAttribute("data",map);
    }

}
