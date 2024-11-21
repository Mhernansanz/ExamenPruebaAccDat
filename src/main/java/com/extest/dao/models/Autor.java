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
import jakarta.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author tarde
 */
@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String country;
    private String name;
    
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_autor")
    private Set<Book> books = new HashSet<>();

    public Autor() {
    }

    public Autor(String country, String name) {
        this.country = country;
        this.name = name;
    }
    
    public JSONObject toJSONObject(){
        JSONObject jsonAutor = new JSONObject();
        jsonAutor.put("id", this.getId());
        jsonAutor.put("name", this.getName());
        jsonAutor.put("country", this.getCountry());
        JSONArray jsonBooks = new JSONArray();
        for (Book book : books) {
            jsonBooks.add(book.toJSONObject());
        }
        jsonAutor.put("books", jsonBooks);
        return jsonAutor;
    }

    @Override
    public String toString() {
        return "autor";
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
    
    
}
