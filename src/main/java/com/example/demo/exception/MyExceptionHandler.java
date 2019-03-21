package com.example.demo.exception;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Created by baoyu on 2018/9/11.
 */
/**
 * 统一异常处理注解,捕获到页面异常，打印堆栈，然后跳转error页面.
 */

@ControllerAdvice
public class MyExceptionHandler {

    public static final String ERROR="/thymeleaf/myerror";
    public static final Logger logger = LoggerFactory.getLogger(MyExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    public Object errorHandler(HttpServletRequest request, HttpServletResponse response, Exception e) throws Exception{
        logger.error(">>>>>>>>> 遇到异常... >>>>>>>>");
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("exception",e);
        modelAndView.addObject("url",request.getRequestURI());
        modelAndView.addObject("timestamp",new Date());
        modelAndView.setViewName(ERROR);
        return modelAndView;
    }
}
