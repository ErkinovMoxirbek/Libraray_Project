package org.example.Controller;

import org.example.DTO.Book;
import org.example.DTO.User;
import org.example.Repository.BookRepository;
import org.example.Service.StudentService;
import org.example.Util.ScannerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller

public class StudentController {
    @Autowired
    private StudentService studentService;
    public void menu(User user){
        boolean status = true;
        while (status){
            System.out.println("""
                    /** -menu- **/
                    1. Book list;
                    2. Take book;
                    3. Taken book;
                    4. Return book;
                    5. History;
                    6. Order book;
                    0. Exit;
                    """);
            switch (ScannerUtil.getAction()){
                case 1 ->studentService.bookList();
                case 2 ->studentService.takeBook(user);
                case 3 ->studentService.takenBook();
                case 4 ->studentService.returnBook();
                case 5 ->studentService.history();
                case 6 ->studentService.orderBook();
                case 0 -> {
                    System.out.println("Exited!");
                    status = false;
                }
            }
        }
    }






}
