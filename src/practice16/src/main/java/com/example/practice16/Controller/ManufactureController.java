package com.example.practice16.Controller;

import com.example.practice16.DTO.ManufactureDTO;
import com.example.practice16.Entity.Manufacture;
import com.example.practice16.Service.ManufactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manufactures")
public class ManufactureController {
    @Autowired
    ManufactureService service;
    @PostMapping("/create")
    public String createManufacture(@RequestBody Manufacture body){
        return service.addManufacture(body);
    }
    @GetMapping("/get")
    public List<ManufactureDTO> getManufactures(){
        return service.getAllManufactures();
    }

    @GetMapping("/get/{id}")
    public ManufactureDTO getManufacture(@PathVariable int id){
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
