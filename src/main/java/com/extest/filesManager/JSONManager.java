/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.extest.filesManager;

import com.extest.dao.DAOManager;
import com.extest.dao.models.Autor;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author tarde
 */
public class JSONManager {
    public static void createJSON(String path, List<Autor> autorList){
        JSONArray jsonAutorList = new JSONArray();
        completeJSON(jsonAutorList, autorList);
        writeJSON(path, jsonAutorList);
    }
    private static void writeJSON(String path, JSONArray listaAutores){
        try(FileWriter file = new FileWriter(path)){
            file.write(listaAutores.toJSONString());
            file.flush();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

    private static void completeJSON(JSONArray listaAutores, List<Autor> autorList) {
        JSONObject actualAutor;
        for (Autor autor : autorList) {
            actualAutor = autor.toJSONObject();
            listaAutores.add(actualAutor);
        }
    }
}
