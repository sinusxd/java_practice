package com.example.practice16.Entity;

import com.example.practice16.DTO.ManufactureDTO;
import jakarta.persistence.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "manufacture")
public class Manufacture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    @Column(name = "name")
    String name;
    @Column(name = "address")
    String address;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "manufacture")
    List<Phone> phoneList;

    public Manufacture(String name, String address) {
        this.name = name;
        this.address = address;
    }
    public Manufacture() {

    }

    public int getId(){
        return this.id;
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
