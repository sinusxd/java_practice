package com.example.practice17.Controller;

import com.example.practice17.DTO.ManufactureDTO;
import com.example.practice17.Entity.Manufacture;
import com.example.practice17.Service.ManufactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/manufactures")
public class ManufactureController {
    @Autowired
    ManufactureService service;
    @PostMapping
    public String createManufacture(@RequestBody Manufacture body){
        return service.addManufacture(body);
    }
    @GetMapping
    public List<ManufactureDTO> getManufactures(@RequestParam Map<String, Object> filters){
        if (filters == null)
            return service.getAllManufactures();
        return service.getManufacturesByFilter(filters);
    }

    @GetMapping("/{id}")
    public ManufactureDTO getManufacture(@PathVariable int id){
        return service.getManufacture(id);
    }

    @DeleteMapping("/{id}")
    public String removeManufacture(@PathVariable int  id){
        if(service.removeManufacture(id))
           return "Запись с номером " + id + " удалена!";
        else
            return "Ошибка! Запись не найдена!";
    }

}
