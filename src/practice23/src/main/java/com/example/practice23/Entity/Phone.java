package com.example.practice23.Entity;
import com.example.practice23.DTO.PhoneDTO;
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
}
