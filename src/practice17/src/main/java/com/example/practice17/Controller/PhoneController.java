package com.example.practice17.Controller;


import com.example.practice17.DTO.PhoneDTO;
import com.example.practice17.Service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/phones")
public class PhoneController {
    @Autowired
    PhoneService service;
    @PostMapping
    public String createPhone(@RequestBody PhoneDTO body){
        System.out.println("test");
        return service.addPhone(body);
    }
    @GetMapping
    public List<PhoneDTO> getPhone(@RequestParam Map<String, Object> filters){
        System.out.println(filters);
        if (filters == null)
            return service.getAllPhones();
        return service.getPhoneByFilter(filters);
    }

    @GetMapping("/{id}")
    public PhoneDTO getPhone(@PathVariable int id){
        return service.getPhone(id);
    }

    @DeleteMapping("/{id}")
    public String removeManufacture(@PathVariable int  id){
        if(service.removePhone(id))
            return "Запись с номером " + id + " удалена!";
        else
            return "Ошибка! Запись не найдена!";
    }

}
