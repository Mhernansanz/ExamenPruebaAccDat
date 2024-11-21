/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.extest.filesManager;

import com.extest.dao.DAOManager;
import com.extest.dao.models.Autor;
import com.extest.dao.models.Book;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author tarde
 */
public class CSVManager {
    public static List<Book> readBookCSV(String path) throws FileNotFoundException{
        List<Book> list = new ArrayList<>();
         
        File f = new File(path);
        try(Scanner sc = new Scanner(f)){
            sc.nextLine();
            Integer year;
            String nameAutor;
            String title;
            Autor autor;
            
            String parts[];
            while(sc.hasNextLine()){
                parts = sc.nextLine().split(",");
                nameAutor = parts[0];
                title = parts[1];
                year = Integer.parseInt(parts[2]);
                autor = DAOManager.getAutorByName(nameAutor);
                list.add(new Book(year, title, autor));
            }
        }
        
        return list;
    }
    
    public static List<Autor> readAutorCSV(String path) throws FileNotFoundException{
         List<Autor> list = new ArrayList<>();
         
        File f = new File(path);
        try(Scanner sc = new Scanner(f)){
            sc.nextLine();
            String name;
            String country;
            
            String parts[];
            while(sc.hasNextLine()){
                parts = sc.nextLine().split(",");
                name = parts[0];
                country = parts[1];
                list.add(new Autor(country, name));
            }
        }
        
        return list;
    }
}
