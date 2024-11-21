/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.extest.dao.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.json.simple.JSONObject;

/**
 *
 * @author tarde
 */
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Integer year;
    private String title;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_autor")
    private Autor autor;

    public Book() {
    }

    public Book(Integer year, String title, Autor autor) {
        this.year = year;
        this.title = title;
        this.autor = autor;
    }
    
    public JSONObject toJSONObject(){
        JSONObject jsonBook = new JSONObject();
        jsonBook.put("id", this.id);
        jsonBook.put("year", this.year);
        jsonBook.put("title", this.title);
        jsonBook.put("autor_id", this.autor.getId());
        return jsonBook;
    }

    @Override
    public String toString() {
        return "libro";
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
    
    
    
}
