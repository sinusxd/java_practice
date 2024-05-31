package com.example.practice18.Entity;

import com.example.practice18.DTO.ManufactureDTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Manufacture {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name;
    String address;

    @OneToMany(mappedBy = "manufacture")
    List<Phone> phoneList;

    public Manufacture(String name, String address) {
        this.name = name;
        this.address = address;
    }
    public Manufacture() {}

    public Manufacture(ManufactureDTO manufactureDTO) {
        this.id = manufactureDTO.getId();
        this.name = manufactureDTO.getName();
        this.address = manufactureDTO.getAddress();
        if (manufactureDTO.getPhoneList() != null)
            this.phoneList = manufactureDTO.getPhoneList().stream()
                    .map(Phone::new).collect(Collectors.toList());
    }

    public Long getId(){
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public List<Phone> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(List<Phone> phoneList) {
        this.phoneList = phoneList;
    }

    public void addPhone(Phone phone){
        if(phoneList == null)
            phoneList = new ArrayList<>();
        phoneList.add(phone);
        phone.setManufacture(this);
    }

}
