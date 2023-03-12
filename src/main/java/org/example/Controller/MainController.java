package org.example.Controller;

import org.example.DTO.User;
import org.example.Enums.Role;
import org.example.Repository.UserRepository;
import org.example.Util.ScannerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Controller
public class MainController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private StudentController studentController;
    @Autowired
    private AdminController adminController;
    public void start(){
        boolean status = true;
        while (status){
            System.out.println("""
               / ** -menu- ** /
               1. Login
               0. Exit
                """);
            switch (ScannerUtil.getAction()){
                case 1 -> login();
                case 0 -> {
                    System.out.println("Exited");
                    status = false;
                }
                default -> System.out.println("not found");
            }
        }

    }
    public void login(){
        User user = new User();
        user = userRepository.getUserByPhone(ScannerUtil.getPhoneNumber());
        if (user != null){
            String pswd = ScannerUtil.getPassword();
            if (user.getPswd().equals(pswd)){
                if (user.getRole().equals(Role.STUDENT)){
                    studentController.menu(user);
                } else if (user.getRole().equals(Role.ADMIN)) {
                    adminController.menu(user);
                }
            }
            else {
                System.err.println("Invalid password or accound blocked");
            }
        }else {
            System.out.println("Exited.");
        }

    }
}
