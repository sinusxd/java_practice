package com.example.practice24.Entity;
import com.example.practice24.DTO.PhoneDTO;
import jakarta.persistence.*;

@Entity
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name;
    String creationYear;

    @ManyToOne
    @JoinColumn(name = "manufacture_id")
    Manufacture manufacture;

    public Phone(){}
    public Phone(String name, String creationYear, Manufacture manufacture) {
        this.name = name;
        this.creationYear = creationYear;
        this.manufacture = manufacture;
    }
    public Phone(PhoneDTO phoneDTO){
        this.name = phoneDTO.getName();
        this.creationYear = phoneDTO.getCreationYear();
    }

    public String getName() {
        return name;
    }

    public String getCreationYear() {
        return creationYear;
    }

    public Manufacture getManufacture() {
        return manufacture;
    }

    public void setManufacture(Manufacture manufacture) {
        this.manufacture = manufacture;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreationYear(String creationYear) {
        this.creationYear = creationYear;
    }
}
