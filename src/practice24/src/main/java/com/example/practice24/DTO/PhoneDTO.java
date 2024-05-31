package com.example.practice24.DTO;

import com.example.practice24.Entity.Phone;

public class PhoneDTO {

    private Long id;
    private String name;
    private String creationYear;
    private Long manufactureId;

    public PhoneDTO(){}

    public PhoneDTO(Phone phone){
        this.id = phone.getId();
        this.name = phone.getName();
        this.creationYear = phone.getCreationYear();
        if (phone.getManufacture() != null)
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

    public Long getManufactureId() {
        return manufactureId;
    }

    public void setManufactureId(Long manufactureId) {
        this.manufactureId = manufactureId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
