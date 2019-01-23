package com.syw.demo1.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Department {
    private int id;
    private String name;
}
