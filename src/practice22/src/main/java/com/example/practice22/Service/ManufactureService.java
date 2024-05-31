package com.example.practice22.Service;

import com.example.practice22.DTO.ManufactureDTO;
import com.example.practice22.DynamicSpecifications;
import com.example.practice22.Entity.Manufacture;
import com.example.practice22.Repository.ManufactureRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Slf4j
public class ManufactureService {
    @Autowired
    ManufactureRepo manufactureRepo;

    public String addManufacture(ManufactureDTO manufactureDTO){
        manufactureRepo.save(new Manufacture(manufactureDTO));
        log.info("add manufacture");
        return "Мануфактура успешно добавлена!";
    }
    public ManufactureDTO getManufacture(Long id) throws Exception{
        Optional<Manufacture> manufacture = manufactureRepo.findById(id);
        if (manufacture.isPresent()) {
            log.info("get manufacture by id");
            return new ManufactureDTO(manufacture.get());
        }
        log.info("Exception: manufacture with id: " + id + " was not found");
        throw new Exception("Мунафактура с id: " + id + " не найдена!");
    }
    public List<ManufactureDTO> getAllManufacturesForBackup(){
        Iterable<Manufacture> manufactures = manufactureRepo.findAll();
        List <Manufacture> manufactureList = new ArrayList<>();
        manufactures.forEach(manufactureList::add);
        manufactureList.stream().forEach(e -> e.getPhoneList());
        return manufactureList.stream().map(ManufactureDTO::new).collect(Collectors.toList());
    }
    public List<ManufactureDTO> getAllManufactures(){
        Iterable<Manufacture> manufactures = manufactureRepo.findAll();
        log.info("get all manufactures");
        return StreamSupport.stream(manufactures.spliterator(), true).map(ManufactureDTO::new)
                .collect(Collectors.toList());
    }

    public List<ManufactureDTO> getManufacturesByFilter(Map<String, Object> filters){
        log.info("get manufactures by filter");
        return manufactureRepo.findAll(DynamicSpecifications.byFilter(filters)).stream().map(ManufactureDTO::new)
                .collect(Collectors.toList());
    }

    public String  removeManufacture(Long id) throws Exception{
        if(manufactureRepo.findById(id).isPresent()) {
            manufactureRepo.deleteById(id);
            log.info("manufacture with id: " + id + " has been removed");
            return "Мануфактура с id: " + id + " удалена!";
        }
        log.info("manufacture with id: " + id + " was not found");
        throw new Exception("Мануфактура с id: " + id + " не найдена!");
    }
}
