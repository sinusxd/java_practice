package com.example.practice16.Service;

import com.example.practice16.DTO.PhoneDTO;
import com.example.practice16.Entity.Manufacture;
import com.example.practice16.Entity.Phone;
import jakarta.annotation.PreDestroy;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PhoneService {
    private final SessionFactory factory;
    @Autowired
    public PhoneService(SessionFactory factory){
        this.factory = factory;
    }

    public String addPhone(PhoneDTO phoneDTO){
        Phone phone = new Phone(phoneDTO);

        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            Manufacture manufacture = session.get(Manufacture.class, phoneDTO.getManufactureId());
            manufacture.addPhone(phone);
            session.save(manufacture);
            session.getTransaction().commit();
        }
        catch (Exception e){
            return e.getMessage();
        }
        finally {
            session.close();
        }
        return "Телефон успешно добавлен!";
    }
    public PhoneDTO getPhone(int id){
        Session session = null;
        Phone phone = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            phone = session.get(Phone.class, id);
            session.getTransaction().commit();
        }
        catch (Exception e){
            return null;
        }
        finally {
            session.close();
        }
        return new PhoneDTO(phone);

    }
    public List<PhoneDTO> getAllPhones(){
        Session session = null;
        Phone phone = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            Query<Phone> query = session.createQuery("FROM Phone", Phone.class);
            session.getTransaction().commit();
            List<Phone> phones = query.getResultList();
            return phones.stream().map(PhoneDTO::new).collect(Collectors.toList());
        }
        catch (Exception e){
            return null;
        }
        finally {
            session.close();
        }
    }

    public Boolean removePhone(int id){
        Session session = null;
        Phone phone = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            session.createQuery("DELETE FROM Phone WHERE id = :phoneId")
                    .setParameter("phoneId", id).executeUpdate();
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
