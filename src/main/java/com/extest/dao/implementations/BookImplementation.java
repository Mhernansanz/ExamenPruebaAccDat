/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.extest.dao.implementations;

import com.extest.dao.interfaces.BookInterface;
import com.extest.dao.models.Autor;
import com.extest.dao.models.Book;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author tarde
 */
public class BookImplementation implements BookInterface{
    
    @Override
    public List<Book> getBooksByAutor(Session session, Autor autor) {
        Query query = session.createQuery("SELECT b FROM Book b WHERE b.autor=:autor", Book.class);
        query.setParameter("autor", autor);
        return query.getResultList();
    }
    
    @Override
    public List<Book> getBooks(Session session) {
        return session.createQuery("FROM Book", Book.class).getResultList();
    }

    @Override
    public void createBook(Session session, Book book) {
        session.beginTransaction();
        
        session.persist(book);
        
        session.getTransaction().commit();
    }

    @Override
    public void createBooks(Session session, List<Book> books) {
        session.beginTransaction();
        
        for (Book book : books) {
            session.persist(book);
        }
        
        session.getTransaction().commit();
    }

    @Override
    public Book getBookById(Session session, Long id) {
        Query query = session.createQuery("SELECT b FROM Book b WHERE b.id=:id", Book.class);
        query.setParameter("id", id);
        return (Book) query.getSingleResult();
    }

    @Override
    public void updateBook(Session session, Book book) {
        session.beginTransaction();
        Query query = session.createQuery("UPDATE Book SET year=:year, title=:title, autor=:autor WHERE id=:id");
        query.setParameter("year", book.getYear());
        query.setParameter("title", book.getTitle());
        query.setParameter("autor", book.getAutor());
        query.setParameter("id", book.getId());
        query.executeUpdate();
        session.getTransaction().commit();
    }
    
}
