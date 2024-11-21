/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.extest;

import com.extest.filesManager.CSVManager;
import com.extest.dao.DAOManager;
import com.extest.dao.models.Autor;
import com.extest.dao.models.Book;
import com.extest.filesManager.JSONManager;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Miguel Garcia
 */
public class Exec {
    public static void main(String[] args) {
        try {
            //      Mapea los datos del csv autores.csv en una lista de objetos
            List<Autor> autors = CSVManager.readAutorCSV("src/main/files/autores.csv");
            
            //      Sube esos datos a la base de datos
            DAOManager.createAutors(autors);
            
            //      Mapea los datos del csv libros.csv en una lista de objetos
            List<Book> books = CSVManager.readBookCSV("src/main/files/libros.csv");
            
            //      Sube esos datos a la base de datos
            DAOManager.createBooks(books);
            
            
            //      Cojo el primer libro y lo guardo como b
            Book b = DAOManager.listBooks().getFirst();
            
            //      Modifico el libro:
            b.setTitle("El otoño del patriarca");
            b.setYear(1980);
            
            //      Hago un UPDATE
            DAOManager.updateBook(b);
            
            /*      Hago una consulta de autores filtrando por nombre
            y guardo el resultado en una lista, (la consulta me devuelve
            un único valor ya que en libros.csv autor actua como conector,
            por lo que asumo que es una variable de caracter UNIQUE)*/
            List<Autor> autorList =  new ArrayList<>();
            autorList.add(DAOManager.getAutorByName("Gabriel Garcia Marquez"));
            
            //      Exporto un JSON con la consulta
            JSONManager.createJSON("src/main/files/consulta.json", autorList);
            
        } catch (FileNotFoundException ex) {
            System.out.println("No se ha encontrado el archivo");
        }catch (Exception ex){
            System.out.println("Error inesperado");
        }
    }
}
