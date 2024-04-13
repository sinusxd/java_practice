package com.example.practice14.Controller;

import com.example.practice14.Entity.Manufacture;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/manufactures")
public class ManufactureController {
    List<Manufacture> manufactureList = new ArrayList<>();

    @PostMapping("/create")
    public String createManufacture(@RequestBody Manufacture body){
        manufactureList.add(body);
        return "Мануфактура " + body.getName();

    }
    @GetMapping("/get")
    public List<Manufacture> getManufactures(){
        return manufactureList;
    }

    @GetMapping("/get/{name}")
    public Manufacture getManufacture(@PathVariable String name){
        for (Manufacture manufacture : manufactureList) {
            if (manufacture.getName().equals(name))
                return manufacture;
        }
        return null;
    }

    @DeleteMapping("/remove/{name}")
    public String remevoManufacture(@PathVariable String  name){
        for (Manufacture manufacture : manufactureList) {
            if (manufacture.getName().equals(name))
                manufactureList.remove(manufacture);
        }
        return null;
    }

}
