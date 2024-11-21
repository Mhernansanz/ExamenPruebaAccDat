/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.extest.dao.implementations;

import com.extest.dao.interfaces.AutorInterface;
import com.extest.dao.models.Autor;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author tarde
 */
public class AutorImplementation implements AutorInterface{

    @Override
    public Autor getAutorByName(Session session, String name) {
        Query query = session.createQuery("FROM Autor WHERE name=:name", Autor.class);
        query.setParameter("name", name);
        List<Autor> list = query.getResultList();
        if(!list.isEmpty()){
            return list.getFirst();
        }else{
            return null;
        }
    }
    
    @Override
    public List<Autor> getAutors(Session session) {
        return session.createQuery("FROM Autor", Autor.class).getResultList();
    }

    @Override
    public void createAutor(Session session, Autor autor) {
        session.beginTransaction();
        
        session.persist(autor);
        
        session.getTransaction().commit();
    }
    public void createAutors(Session session, List<Autor> autors) {
        session.beginTransaction();
        
        for (Autor autor : autors) {
            session.persist(autor);
        }
        
        session.getTransaction().commit();
    }

    
    
}
