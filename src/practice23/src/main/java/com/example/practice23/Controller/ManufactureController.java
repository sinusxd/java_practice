package com.example.practice23.Controller;

import com.example.practice23.DTO.ManufactureDTO;
import com.example.practice23.Service.ManufactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/manufactures")
public class ManufactureController {
    @Autowired
    ManufactureService service;
    @PostMapping
    public ResponseEntity createManufacture(@RequestBody ManufactureDTO body){
        return ResponseEntity.ok(service.addManufacture(body));
    }
    @GetMapping
    public ResponseEntity getManufactures(@RequestParam Map<String, Object> filters){
        if (filters == null)
            return ResponseEntity.ok(service.getAllManufactures());
        return ResponseEntity.ok(service.getManufacturesByFilter(filters));
    }

    @GetMapping("/{id}")
    public ResponseEntity getManufacture(@PathVariable Long id){
        try {
            return ResponseEntity.ok(service.getManufacture(id));
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity removeManufacture(@PathVariable Long  id){
        try {
            return ResponseEntity.ok(service.removeManufacture(id));
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
