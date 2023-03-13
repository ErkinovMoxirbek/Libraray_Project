package org.example;

import org.example.Controller.MainController;
import org.example.Repository.BookRepository;
import org.example.Repository.UserRepository;
import org.example.config.Config;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDateTime;

public class Main {


    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        MainController mainController = (MainController) context.getBean("mainController");
        mainController.start();
//        UserRepository userRepository = (UserRepository) context.getBean("userRepository");
//        BookRepository bookRepository = (BookRepository) context.getBean("bookRepository");
//        bookRepository.initTable();

    }

}