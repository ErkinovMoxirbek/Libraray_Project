package org.example.Service;

import org.example.DTO.Book;
import org.example.Repository.BookRepository;
import org.example.Util.ScannerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

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
        getResult(bookRepository.save(book));
    }

    public void DeleteBook() {
        System.out.print("Enter Id : ");
        Integer id = ScannerUtil.scannerInt.nextInt();
        getResult(bookRepository.deleteBook(id));
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
    public void getResult(int n){
        if (n == 1) System.out.println("successfully!");
        else System.out.println("failed!");
    }
}
