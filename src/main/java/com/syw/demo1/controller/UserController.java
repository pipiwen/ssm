package com.syw.demo1.controller;

import com.syw.demo1.entity.User;
import com.syw.demo1.service.UserService;
import com.syw.util.PageInfo;
import com.syw.util.ResultBean;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private ServletContext servletContext;
@RequestMapping("list")
    public String findUserList(){
        return "/user/userList";
    }

    @RequestMapping(value = "userList")
    @ResponseBody
    public PageInfo<User> userList() throws Exception{
       PageInfo<User>pageInfo=null;
        try{
            pageInfo=userService.getUserPageList();

        }catch (Exception e){
           e.printStackTrace();
        }
        return pageInfo;
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
    @RequestMapping("userExport")
    public void userExport(HttpServletResponse response)throws Exception{
        System.out.println("--------------------------------进入excelExport");
       String fileName="userList.xlsx";
       List<User> list= userService.findListAll();
        Workbook wb= new XSSFWorkbook();
        String [] header={"编号","用户名","密码"};
        int rowIndex=0;
        Sheet sheet=wb.createSheet();
        Row row=sheet.createRow(rowIndex++);//创建行建立索引
        for(int i=0;i<header.length;i++) {
            row.createCell(i).setCellValue(header[i]);
        }
        for(int j=0;j<list.size();j++){
            row=sheet.createRow(rowIndex++);
            row.createCell(0).setCellValue(list.get(j).getId());
            row.createCell(1).setCellValue(list.get(j).getName());
            row.createCell(2).setCellValue(list.get(j).getPassword());
        }
        response.setHeader("Content-Disposition", "attachment;filename="+
                new String(fileName.getBytes("utf-8"),"iso8859-1"));
        response.setContentType("application/ynd.ms-excel;charset=utf-8");
        OutputStream os=response.getOutputStream();
        wb.write(os);
        os.flush();
        os.close();
    }
    @RequestMapping(value = "uploadForm")
    public String uploadForm(){

    return "user/fileUpload";
    }

    @RequestMapping(value = "upload")
    public String fileUpload(User user,MultipartFile file) {
            ResultBean resultBean = new ResultBean();
            try {
                String fileName = file.getOriginalFilename();//获取文件名
                String saveDir = servletContext.getRealPath("/updateload");
                Files.copy(file.getInputStream(), Paths.get(saveDir, fileName));
            } catch (DuplicateKeyException e) {
                resultBean.setSuccess(false);
                resultBean.setMsg("记录已存在");
            } catch (NullPointerException e) {
                resultBean.setSuccess(false);
                resultBean.setMsg("NPE异常：" + e.getMessage());
            } catch (IllegalStateException e) {
                resultBean.setSuccess(false);
                resultBean.setMsg(e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
                resultBean.setSuccess(false);
            }
            return "/user/userList";
        }
    }
