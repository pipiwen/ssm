package com.syw.demo1.controller;

import com.syw.demo1.entity.Employee;
import com.syw.demo1.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("employee")
    public class EmpController {
        @Autowired
        private EmpService empService;

        @RequestMapping("test1")
        public String test1(Model model){
            System.out.println("...进入test1");
            List<Employee>empList=empService.findEmpList();
            model .addAttribute("empList",empList);

            return "emp";
        }
}
