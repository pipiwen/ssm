package com.syw.demo1.dao;

import com.syw.demo1.entity.Employee;
import com.syw.rad.annotation.persistence.annotation.MyBatisDao;

import java.util.List;
@MyBatisDao

public interface EmployeeDao {
    List<Employee> findListAll();

}
