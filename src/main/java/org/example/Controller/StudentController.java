package org.example.Controller;

import org.example.DTO.Book;
import org.example.Repository.BookRepository;
import org.example.Util.ScannerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller

public class StudentController {
    @Autowired
    private BookRepository bookRepository;
    public void menu(){
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
                case 1 ->bookList();
                case 2 ->takeBook();
                case 3 ->takenBook();
                case 4 ->returnBook();
                case 5 ->history();
                case 6 ->orderBook();
                case 0 -> {
                    System.out.println("Exited!");
                    status = false;
                }
            }
        }
    }

    private void orderBook() {
        ///
    }

    private void history() {
        ///
    }

    private void returnBook() {
        
    }

    private void takenBook() {

    }
    private void takeBook() {
        
    }

    private void bookList() {
        List<Book> bookList = bookRepository.getList();
        for(Book b : bookList){
            System.out.println(b.toString());
        }
    }
}
