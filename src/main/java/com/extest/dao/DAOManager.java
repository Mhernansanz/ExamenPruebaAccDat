/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.extest.dao;

import com.extest.dao.implementations.AutorImplementation;
import com.extest.dao.implementations.BookImplementation;
import com.extest.dao.models.Autor;
import com.extest.dao.models.Book;
import com.extest.hibernate.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author tarde
 */
public class DAOManager {
    public static Book getBookById(Long id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        BookImplementation bookImpl = new BookImplementation();
        Book book = bookImpl.getBookById(session, id);
        session.close();
        return book;
    }
    
    public static void updateBook(Book book){
        Session session = HibernateUtil.getSessionFactory().openSession();
        BookImplementation bookImpl = new BookImplementation();
        bookImpl.updateBook(session, book);
        session.close();
    }
    
    public static List<Book> getBooksByAutor(Autor autor){
        List<Book> list;
        Session session = HibernateUtil.getSessionFactory().openSession();
        BookImplementation bookImpl = new BookImplementation();
        list = bookImpl.getBooksByAutor(session, autor);
        session.close();
        return list;
    }
    
    public static Autor getAutorByName(String name){
        Session session = HibernateUtil.getSessionFactory().openSession();
        AutorImplementation autorImpl = new AutorImplementation();
        Autor autor = autorImpl.getAutorByName(session, name);
        session.close();
        return autor;
    }
    public static List<Autor> listAutors(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        AutorImplementation autorImpl = new AutorImplementation();
        List<Autor> list = autorImpl.getAutors(session);
        session.close();
        return list;
    }
    public static void createAutor(Autor autor){
        Session session = HibernateUtil.getSessionFactory().openSession();
        AutorImplementation autorImpl = new AutorImplementation();
        autorImpl.createAutor(session, autor);
        session.close();
    }
    public static void createAutors(List<Autor> autors){
        Session session = HibernateUtil.getSessionFactory().openSession();
        AutorImplementation autorImpl = new AutorImplementation();
        autorImpl.createAutors(session, autors);
        session.close();
    }
    
    public static List<Book> listBooks(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        BookImplementation bookImpl = new BookImplementation();
        List<Book> list = bookImpl.getBooks(session);
        session.close();
        return list;
    }
    public static void createBook(Book book){
        Session session = HibernateUtil.getSessionFactory().openSession();
        BookImplementation bookImpl = new BookImplementation();
        bookImpl.createBook(session, book);
        session.close();
    }
    public static void createBooks(List<Book> books){
        Session session = HibernateUtil.getSessionFactory().openSession();
        BookImplementation bookImpl = new BookImplementation();
        bookImpl.createBooks(session, books);
        session.close();
    }
    
}
