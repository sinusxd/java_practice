package com.example.practice14.Controller;

import com.example.practice14.Entity.Manufacture;
import com.example.practice14.Entity.Phone;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/phones")
public class PhoneController {
    List<Phone> phoneList = new ArrayList<>();

    @PostMapping("/create")
    public String creatPhone(@RequestBody Phone body){
        phoneList.add(body);
        return "Телефон " + body.getName();

    }
    @GetMapping("/get")
    public List<Phone> getPhoneList(){
        return phoneList;
    }

    @GetMapping("/get/{name}")
    public Phone getPhone(@PathVariable String name){
        for (Phone phone : phoneList) {
            if (phone.getName().equals(name))
                return phone;
        }
        return null;
    }
    @DeleteMapping("/remove/{name}")
    public String remevoManufacture(@PathVariable String  name){
        for (Phone phone : phoneList) {
            if (phone.getName().equals(name))
                phoneList.remove(phone);
        }
        return null;
    }
}
