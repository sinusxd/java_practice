package com.example.practice16.Service;

import com.example.practice16.DTO.ManufactureDTO;
import com.example.practice16.DTO.PhoneDTO;
import com.example.practice16.Entity.Manufacture;
import com.example.practice16.Entity.Phone;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import jakarta.annotation.PreDestroy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ManufactureService {
    private final SessionFactory factory;
    @Autowired
    public ManufactureService(SessionFactory factory){
        this.factory = factory;
    }

    public String addManufacture(Manufacture manufacture){
        System.out.println(manufacture);
        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            session.save(manufacture);
            session.getTransaction().commit();
        }
        catch (Exception e){
            return e.getMessage();
        }
        finally {
            session.close();
        }
        return "Мануфактура успешно создана!";
    }
    public ManufactureDTO getManufacture(int id){
        Session session = null;
        Manufacture manufacture = null;
        List<PhoneDTO> phoneDTOS = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            manufacture = session.get(Manufacture.class, id);
            phoneDTOS = manufacture.getPhoneList().stream().map(PhoneDTO::new)
                    .collect(Collectors.toList());
            session.getTransaction().commit();
        }
        catch (Exception e){
            return null;
        }
        finally {
            session.close();
        }
        ManufactureDTO manufactureDTO = new ManufactureDTO(manufacture);
        manufactureDTO.setPhoneList(phoneDTOS);
        return manufactureDTO;

    }
    public List<ManufactureDTO> getAllManufactures(){
        Session session = null;
        Manufacture manufacture = null;
        List<ManufactureDTO> manufactureDTOS = new ArrayList<>();
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            Query<Manufacture> query = session.createQuery("FROM Manufacture", Manufacture.class);
            session.getTransaction().commit();
            List<Manufacture> manufactures = query.getResultList();
            for(Manufacture man: manufactures){
                List<PhoneDTO> phoneDTOS = new ArrayList<>();
                for(Phone phone: man.getPhoneList()){
                    phoneDTOS.add(new PhoneDTO(phone));
                }
                ManufactureDTO manufactureDTO = new ManufactureDTO(man);
                manufactureDTO.setPhoneList(phoneDTOS);
                manufactureDTOS.add(manufactureDTO);
            }
            return manufactureDTOS;
        }
        catch (Exception e){
            return null;
        }
        finally {
            session.close();
        }
    }

    public Boolean removeManufacture(int id){
        Session session = null;
        Manufacture manufacture = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            Manufacture m = session.get(Manufacture.class, id);
            session.delete(m);
            session.getTransaction().commit();
        }
        catch (Exception e){
            return false;
        }
        finally {
            session.close();
        }
        return true;
    }


    @PreDestroy
    void destroy(){
        factory.close();
    }
}
