package com.example.practice16.DTO;

import com.example.practice16.Entity.Phone;
import com.example.practice16.Service.ManufactureService;
import org.springframework.beans.factory.annotation.Autowired;

public class PhoneDTO {

    private int id;
    private String name;
    private String creationYear;
    private int manufactureId;

    public PhoneDTO(){}

    public PhoneDTO(Phone phone){
        this.id = phone.getId();
        this.name = phone.getName();
        this.creationYear = phone.getCreationYear();
        this.manufactureId = phone.getManufacture().getId();
    }

    // Геттеры и сеттеры
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreationYear() {
        return creationYear;
    }

    public void setCreationYear(String creationYear) {
        this.creationYear = creationYear;
    }

    public Integer getManufactureId() {
        return manufactureId;
    }

    public void setManufactureId(Integer manufactureId) {
        this.manufactureId = manufactureId;
    }

    public int getId() {
        return id;
    }
}
