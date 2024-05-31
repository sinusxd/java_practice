package com.example.practice18.Service;
import com.example.practice18.DTO.ManufactureDTO;
import com.example.practice18.DTO.PhoneDTO;
import com.example.practice18.DynamicSpecifications;
import com.example.practice18.Entity.Manufacture;
import com.example.practice18.Entity.Phone;
import com.example.practice18.Repository.ManufactureRepo;
import com.example.practice18.Repository.PhoneRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PhoneService {
    @Autowired
    private PhoneRepo phoneRepo;


    public String addPhone(PhoneDTO phoneDTO){
        Phone phone = new Phone(phoneDTO);
        Manufacture manufacture = new Manufacture();
        manufacture.setId(phoneDTO.getManufactureId());
        phone.setManufacture(manufacture);
        phoneRepo.save(phone);
        return "Телефон успешно добавлен!";
    }
    public Phone getPhone(Long id) throws Exception {
        Optional<Phone> phone = phoneRepo.findById(id);
        if (phone.isPresent())
            return phone.get();
        throw new Exception("Телефон с id: " + id + " не найден!");
    }
    public List<PhoneDTO> getAllPhones(){
        Iterable<Phone> phones = phoneRepo.findAll();
        return StreamSupport.stream(phones.spliterator(), true).map(PhoneDTO::new)
                .collect(Collectors.toList());
    }

    public List<PhoneDTO> getPhoneByFilter(Map<String, Object> filters){
        return phoneRepo.findAll(DynamicSpecifications.byFilter(filters)).stream().map(PhoneDTO::new)
                .collect(Collectors.toList());
    }

    public String removePhone(Long id) throws Exception{
        if(phoneRepo.findById(id).isPresent()) {
            phoneRepo.deleteById(id);
            return "Телефон с id: " + id + " удалён!";
        }
        throw new Exception("Телефон с id: " + id + " не найден!");
    }
}
