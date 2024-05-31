package com.example.practice16.Controller;

import com.example.practice16.DTO.PhoneDTO;
import com.example.practice16.Entity.Manufacture;
import com.example.practice16.Entity.Phone;
import com.example.practice16.Service.ManufactureService;
import com.example.practice16.Service.PhoneService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/phones")
public class PhoneController {
    @Autowired
    PhoneService service;
    @PostMapping("/create")
    public String createManufacture(@RequestBody PhoneDTO body){
        return service.addPhone(body);
    }
    @GetMapping("/get")
    public List<PhoneDTO> getManufactures(){
        return service.getAllPhones();
    }

    @GetMapping("/get/{id}")
    public PhoneDTO getPhone(@PathVariable int id){
        return service.getPhone(id);
    }

    @DeleteMapping("/remove/{id}")
    public String removeManufacture(@PathVariable int  id){
        if(service.removePhone(id))
            return "Запись с номером " + id + " удалена!";
        else
            return "Ошибка! Запись не найдена!";
    }

}
