package com.example.practice18.Service;

import com.example.practice18.DTO.ManufactureDTO;
import com.example.practice18.DTO.PhoneDTO;
import com.example.practice18.DynamicSpecifications;
import com.example.practice18.Entity.Manufacture;
import com.example.practice18.Entity.Phone;
import com.example.practice18.Repository.ManufactureRepo;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ManufactureService {
    @Autowired
    ManufactureRepo manufactureRepo;

    public String addManufacture(ManufactureDTO manufactureDTO){
        manufactureRepo.save(new Manufacture(manufactureDTO));
        return "Мануфактура успешно добавлен!";
    }
    public ManufactureDTO getManufacture(Long id) throws Exception{
        Optional<Manufacture> manufacture = manufactureRepo.findById(id);
        if (manufacture.isPresent())
            return new ManufactureDTO(manufacture.get());
        throw new Exception("Мунафактура с id: " + id + " не найдена!");
    }
    public List<ManufactureDTO> getAllManufactures(){
        Iterable<Manufacture> manufactures = manufactureRepo.findAll();
        return StreamSupport.stream(manufactures.spliterator(), true).map(ManufactureDTO::new)
                .collect(Collectors.toList());
    }

    public List<ManufactureDTO> getManufacturesByFilter(Map<String, Object> filters){
        return manufactureRepo.findAll(DynamicSpecifications.byFilter(filters)).stream().map(ManufactureDTO::new)
                .collect(Collectors.toList());
    }

    public String  removeManufacture(Long id) throws Exception{
        if(manufactureRepo.findById(id).isPresent()) {
            manufactureRepo.deleteById(id);
            return "Мануфактура с id: " + id + " удалена!";
        }
        throw new Exception("Мануфактура с id: " + id + " не найдена!");
    }
}
