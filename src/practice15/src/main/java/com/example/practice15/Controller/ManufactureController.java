package com.example.practice15.Controller;

import com.example.practice15.Entity.Manufacture;
import com.example.practice15.Service.ManufactureService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/manufactures")
public class ManufactureController {
    @Autowired
    ManufactureService service;
    @PostMapping("/create")
    public String createManufacture(@RequestBody Manufacture body){
        System.out.println("createManufacture");
        return service.addManufacture(body);
    }
    @GetMapping("/get")
    public List<Manufacture> getManufactures(){
        return service.getAllManufactures();
    }

    @GetMapping("/get/{id}")
    public Manufacture getManufacture(@PathVariable int id){
        return service.getManufacture(id);
    }

    @DeleteMapping("/remove/{id}")
    public String removeManufacture(@PathVariable int  id){
        if(service.removeManufacture(id))
           return "Запись с номером " + id + " удалена!";
        else
            return "Ошибка! Запись не найдена!";
    }

}
