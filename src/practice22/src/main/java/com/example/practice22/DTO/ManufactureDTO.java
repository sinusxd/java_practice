package com.example.practice22.DTO;
import com.example.practice22.Entity.Manufacture;

import java.util.List;
import java.util.stream.Collectors;

public class ManufactureDTO {
    Long id;
    String name;
    String address;
    List<PhoneDTO> phoneList;
    ManufactureDTO(){}

    public ManufactureDTO(Manufacture manufacture) {
        this.id = manufacture.getId();
        this.name = manufacture.getName();
        this.address = manufacture.getAddress();
        if (manufacture.getPhoneList() != null)
            this.phoneList = manufacture.getPhoneList().stream().map(PhoneDTO::new)
                    .collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<PhoneDTO> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(List<PhoneDTO> phoneList) {
        this.phoneList = phoneList;
    }

    @Override
    public String toString() {
        return "ManufactureDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneList=" + phoneList +
                '}';
    }
}
