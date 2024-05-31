package com.example.practice16.DTO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.example.practice16.Entity.Manufacture;
import com.example.practice16.Entity.Phone;

import java.util.List;

public class ManufactureDTO {
    int id;
    String name;
    String address;
    List<PhoneDTO> phoneList;
    ManufactureDTO(){}

    public ManufactureDTO(Manufacture manufacture) {
        this.id = manufacture.getId();
        this.name = manufacture.getName();
        this.address = manufacture.getAddress();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
}
