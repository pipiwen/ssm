package com.syw.demo1.service;

import com.syw.demo1.dao.EmployeeDao;
import com.syw.demo1.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpService {
    @Autowired
    private EmployeeDao employeeDao;
    public List<Employee> findEmpList(){
        return employeeDao.findListAll();
    }

}
