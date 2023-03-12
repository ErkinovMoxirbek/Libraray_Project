package org.example.Controller;

import org.example.DTO.Book;
import org.example.DTO.User;
import org.example.Repository.BookRepository;
import org.example.Service.AdminService;
import org.example.Util.ScannerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;
    public void menu(User user){
        boolean status = true;
        while (status){
            System.out.println("""
                    ** -menu- **
                    1. Book list;
                    2. Add book;
                    3. Delete book;
                    4. Student List;
                    5. Add Student;
                    6. Delete student;
                    7. Student Taken book;
                    8. BookTaken History;
                    0. Exit;
                    """);
            switch (ScannerUtil.getAction()){
                case 1 -> adminService.BookList();
                case 2 -> adminService.AddBook();
                case 3 -> adminService.DeleteBook();
                case 4 -> adminService.StudentList();
                case 5 -> adminService.AddStudent();
                case 6 -> adminService.DeleteStudent();
                case 7 -> adminService.StudentTakenBook();
                case 8 -> adminService.BookTakenHistory();
                case 0 -> {
                    System.out.println("Exited!");
                    status = false;
                }
                default -> System.out.println("Not found!");
            }
        }
    }




}
