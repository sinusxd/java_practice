package com.example.practice23.Service;
import com.example.practice23.DTO.PhoneDTO;
import com.example.practice23.DynamicSpecifications;
import com.example.practice23.Entity.Manufacture;
import com.example.practice23.Entity.Phone;
import com.example.practice23.Repository.PhoneRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Slf4j
public class PhoneService {
    @Autowired
    private PhoneRepo phoneRepo;


    public String addPhone(PhoneDTO phoneDTO){
        Phone phone = new Phone(phoneDTO);
        Manufacture manufacture = new Manufacture();
        manufacture.setId(phoneDTO.getManufactureId());
        phone.setManufacture(manufacture);
        phoneRepo.save(phone);
        log.info("add phone");
        return "Телефон успешно добавлен!";
    }
    public Phone getPhone(Long id) throws Exception {
        Optional<Phone> phone = phoneRepo.findById(id);
        if (phone.isPresent()) {
            log.info("get phone by id");
            return phone.get();
        }
        log.info("Exception: phone with id: " + id + " was not found");
        throw new Exception("Телефон с id: " + id + " не найден!");
    }
    public List<PhoneDTO> getAllPhones(){
        Iterable<Phone> phones = phoneRepo.findAll();
        log.info("get all phones");
        return StreamSupport.stream(phones.spliterator(), true).map(PhoneDTO::new)
                .collect(Collectors.toList());
    }

    public List<PhoneDTO> getPhoneByFilter(Map<String, Object> filters){
        log.info("get phones by filter");
        return phoneRepo.findAll(DynamicSpecifications.byFilter(filters)).stream().map(PhoneDTO::new)
                .collect(Collectors.toList());
    }

    public String removePhone(Long id) throws Exception{
        if(phoneRepo.findById(id).isPresent()) {
            log.info("phone with id: " + id + " has been removed");
            phoneRepo.deleteById(id);
            return "Телефон с id: " + id + " удалён!";
        }
        log.info("phone with id: " + id + " was not found");
        throw new Exception("Телефон с id: " + id + " не найден!");
    }
}
