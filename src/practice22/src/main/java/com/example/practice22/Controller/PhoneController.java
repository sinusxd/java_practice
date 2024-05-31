package com.example.practice22.Controller;


import com.example.practice22.DTO.PhoneDTO;
import com.example.practice22.Service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/phones")
public class PhoneController {
    @Autowired
    PhoneService service;
    @PostMapping
    public ResponseEntity createPhone(@RequestBody PhoneDTO body){
        return ResponseEntity.ok(service.addPhone(body));
    }
    @GetMapping
    public ResponseEntity getPhone(@RequestParam Map<String, Object> filters){
        if (filters == null)
            return ResponseEntity.ok(service.getAllPhones());
        return ResponseEntity.ok(service.getPhoneByFilter(filters));
    }

    @GetMapping("/{id}")
    public ResponseEntity getPhone(@PathVariable Long id){
        try {
            return ResponseEntity.ok(service.getPhone(id));
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity removeManufacture(@PathVariable Long  id){
        try {
            return ResponseEntity.ok(service.removePhone(id));
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
