package com.example.practice13;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {
    @Value("${program.student.name}")
    private String name;
    @Value("${program.student.last_name}")
    private String surname;
    @Value("${program.student.group}")
    private String group;
    @PostConstruct
    public void init() {
        System.out.println(name);
        System.out.println(surname);
        System.out.println(group);
    }
}