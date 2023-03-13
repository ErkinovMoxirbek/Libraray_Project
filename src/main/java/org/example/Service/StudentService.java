package org.example.Service;

import org.example.DTO.Book;
import org.example.DTO.StudentBook;
import org.example.DTO.User;
import org.example.Enums.Status;
import org.example.Repository.BookRepository;
import org.example.Repository.StudentBookRepository;
import org.example.Util.ScannerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    public BookRepository bookRepository;
    @Autowired
    private StudentBookRepository studentBookRepository;
    public void bookList() {
        List<Book> bookList = bookRepository.getBookList();
        for(Book b : bookList){
            System.out.println(b.toString());
        }
    }
    public void takeBook(User user) {
        System.out.print("Enter Id : ");
        Book book = bookRepository.getBookById(ScannerUtil.scannerInt.nextInt());
        if (book == null){
            System.out.println("Sorry, the book you were looking for does not exist. \nPlease, try again");
            return;
        }
        StudentBook studentBook = new StudentBook();
        studentBook.setBookId(book.getId());
        studentBook.setStudentId(user.getId());
        studentBook.setStatus(Status.TAKEN);
        studentBook.setReturnedDate(LocalDateTime.now());
        LocalDateTime localDateTime = LocalDateTime.now() ;
        studentBook.setDuration(localDateTime.plusDays(30));
        getResult(studentBookRepository.save(studentBook));
    }
    public void takenBook() {

    }
    public void returnBook() {

    }
    public void history() {
        ///
    }
    public void orderBook() {
        ///
    }

    public void getResult(int n){
        if (n == 1) System.out.println("successfully!");
        else System.out.println("failed!");
    }


}
