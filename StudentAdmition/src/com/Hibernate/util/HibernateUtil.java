package com.Hibernate.util;
import Modle.StudentModle;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import Modle.StudentModle;

public class HibernateUtil {

    private static final SessionFactory factory;

    static {
        try {
            Configuration cfg = new Configuration();
            cfg.addAnnotatedClass(StudentModle.class); 
            cfg.configure("Hibernate.cfg.xml");
            cfg.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
            cfg.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/WebTech");
            cfg.setProperty("hibernate.connection.username", "root");
            cfg.setProperty("hibernate.connection.password", "Olivier@@96");
            cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
            cfg.setProperty("hibernate.hbm2ddl.auto", "update");
            cfg.setProperty("hibernate.show_sql", "true");
            cfg.setProperty("hibernate.format_sql", "true");

            ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
            factory = cfg.buildSessionFactory(registry);
        } catch (Throwable ex) {
            System.err.println("SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return factory;
    }
}
