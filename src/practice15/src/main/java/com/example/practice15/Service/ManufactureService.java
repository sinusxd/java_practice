package com.example.practice15.Service;

import com.example.practice15.Entity.Manufacture;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import jakarta.annotation.PreDestroy;

import java.util.List;
import java.util.Queue;

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
    public Manufacture getManufacture(int id){
        Session session = null;
        Manufacture manufacture = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            manufacture = session.get(Manufacture.class, id);
            session.getTransaction().commit();
        }
        catch (Exception e){
            return null;
        }
        finally {
            session.close();
        }
        return manufacture;

    }
    public List<Manufacture> getAllManufactures(){
        Session session = null;
        Manufacture manufacture = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            Query<Manufacture> query = session.createQuery("FROM Manufacture", Manufacture.class);
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

    public Boolean removeManufacture(int id){
        Session session = null;
        Manufacture manufacture = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            session.createQuery("DELETE FROM Manufacture WHERE id = :manufactureId")
                            .setParameter("manufactureId", id).executeUpdate();
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
