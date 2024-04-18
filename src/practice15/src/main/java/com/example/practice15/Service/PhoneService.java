package com.example.practice15.Service;

import com.example.practice15.Entity.Phone;
import jakarta.annotation.PreDestroy;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PhoneService {
    private final SessionFactory factory;
    @Autowired
    public PhoneService(SessionFactory factory){
        this.factory = factory;
    }

    public String addPhone(Phone phone){
        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            session.save(phone);
            session.getTransaction().commit();
        }
        catch (Exception e){
            return e.getMessage();
        }
        finally {
            session.close();
        }
        return "Телефон успешно создана!";
    }
    public Phone getPhone(int id){
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
        return phone;

    }
    public List<Phone> getAllPhones(){
        Session session = null;
        Phone phone = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            Query<Phone> query = session.createQuery("FROM Phone", Phone.class);
            session.getTransaction().commit();
            return query.list();
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
