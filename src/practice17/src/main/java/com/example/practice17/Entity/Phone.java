package com.example.practice17.Entity;
import com.example.practice17.DTO.PhoneDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "phone")
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    @Column(name = "name")
    String name;
    @Column(name = "creation_year")
    String creationYear;
    @ManyToOne(cascade = CascadeType.ALL)
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

    public int getId() {
        return id;
    }
}
