/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.extest.dao.interfaces;

import com.extest.dao.models.Autor;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author tarde
 */
public interface AutorInterface {
    public Autor getAutorByName(Session session, String name);
    public void createAutor(Session session, Autor autor);
    public void createAutors(Session session, List<Autor> autor);
    public List<Autor> getAutors(Session session);
}
