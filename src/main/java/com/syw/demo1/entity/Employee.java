package com.syw.demo1.entity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
@Component
@Setter
@Getter
public class Employee {
    private int id;
    private String name;
    private int age;
    private BigDecimal salary;
    private Department deptId;


    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", deptId=" + deptId +
                '}';
    }
}
