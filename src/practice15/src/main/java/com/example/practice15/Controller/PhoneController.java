package com.example.practice15.Controller;

import com.example.practice15.Entity.Manufacture;
import com.example.practice15.Entity.Phone;
import com.example.practice15.Service.ManufactureService;
import com.example.practice15.Service.PhoneService;
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
    public String createManufacture(@RequestBody Phone body){
        return service.addPhone(body);
    }
    @GetMapping("/get")
    public List<Phone> getManufactures(){
        return service.getAllPhones();
    }

    @GetMapping("/get/{id}")
    public Phone getPhone(@PathVariable int id){
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
