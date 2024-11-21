/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.extest.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;
    
    public static SessionFactory getSessionFactory(){
        if (sessionFactory == null) {
            try{
                // crear registro
                registry = new StandardServiceRegistryBuilder().configure().build();
                
                // crear recursos de metadata
                MetadataSources sources = new MetadataSources(registry);
                
                // crear metadata
                Metadata metadata = sources.getMetadataBuilder().build();
                
                //crear session factory
                sessionFactory = metadata.getSessionFactoryBuilder().build();
                
                System.out.println(sessionFactory);
            }catch (Exception e){
                e.printStackTrace();
                HibernateUtil.shutdown();
            }
        }
        return sessionFactory;
    }
    
    public static void shutdown(){
        if (registry != null) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}
