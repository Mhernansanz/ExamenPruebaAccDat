/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.extest.dao.interfaces;

import com.extest.dao.models.Autor;
import com.extest.dao.models.Book;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author tarde
 */
public interface BookInterface {
    public Book getBookById(Session session, Long id);
    public void updateBook(Session session, Book book);
    public List<Book> getBooksByAutor(Session session, Autor autor);
    public List<Book> getBooks(Session session);
    public void createBook(Session session, Book book);
    public void createBooks(Session session, List<Book> books);
}
