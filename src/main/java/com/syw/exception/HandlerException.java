package com.syw.exception;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice//对controller增强，这样不用在每个cotroller中配置
public class HandlerException  {
    @ExceptionHandler
    public String error(Exception ex, Model model){
        model.addAttribute("msg",ex.getMessage());
        return "commons/error";
    }
}
