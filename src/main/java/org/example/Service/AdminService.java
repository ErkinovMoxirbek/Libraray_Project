package org.example.Service;

import org.example.DTO.Book;
import org.example.Repository.BookRepository;
import org.example.Util.ScannerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private BookRepository bookRepository;
    public void BookList() {
        List<Book> bookList = bookRepository.getBookList();
        for(Book b : bookList){
            System.out.println(b.toString());
        }
    }
    public void AddBook() {
        Book book = new Book();
        System.out.print("Enter title : ");
        book.setTitle(ScannerUtil.scannerStr.nextLine());
        System.out.print("Enter author : ");
        book.setAuthor(ScannerUtil.scannerStr.nextLine());
        System.out.print("Enter amount : ");
        book.setAmount(ScannerUtil.scannerInt.nextDouble());
        book.setVisible(true);
        int n = bookRepository.save(book);
        if (n == 1) System.out.println("successfully!");
        else System.out.println("failed!");
    }

    public void DeleteBook() {
    }

    public void StudentList() {
    }

    public void AddStudent() {
    }

    public void DeleteStudent() {
    }

    public void StudentTakenBook() {
    }

    public void BookTakenHistory() {
    }
}
