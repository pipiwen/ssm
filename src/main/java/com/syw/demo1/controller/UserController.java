package com.syw.demo1.controller;

import com.syw.demo1.entity.User;
import com.syw.demo1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private ServletContext servletContext;
@RequestMapping("list")
    public String findUserList(Model model){
    model.addAttribute("userModel",userService.findListAll());

        return "userList";
    }
@RequestMapping("login")
     public String login(User user){
    try {
        userService.login(user);
    }catch (Exception e) {
        return "redirect:/login.jsp";
    }
    return "redirect:/user/list";

     }

    @RequestMapping("addFrom")
    public String addFrom(User user){

    return "userAdd";
    }
    @RequestMapping("add")
    public String userAdd(User user, MultipartFile file){
    String fileName=file.getOriginalFilename();//获取文件名
         String saveDir=servletContext.getRealPath("/updateload");
        try {
            Files.copy(file.getInputStream(), Paths.get(saveDir,fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(0==user.getId()) {
        userService.save(user);
    }else {
        userService.edit(user);
    }
        return "redirect:/user/list";
    }
}
