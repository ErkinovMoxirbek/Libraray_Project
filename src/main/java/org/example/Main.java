package org.example;

import org.example.Controller.MainController;
import org.example.Repository.AppealRepository;
import org.example.Repository.BookRepository;
import org.example.Repository.UserRepository;
import org.example.config.Config;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDateTime;

public class Main {


    public static void main(String[] args) {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        factory.close();
        session.close();
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        MainController mainController = (MainController) context.getBean("mainController");
        mainController.start();
//        UserRepository userRepository = (UserRepository) context.getBean("userRepository");
//        BookRepository bookRepository = (BookRepository) context.getBean("bookRepository");
//        bookRepository.initTable();
//        AppealRepository appealRepository = (AppealRepository) context.getBean("appealRepository");
//        appealRepository.initTable();
    }

}