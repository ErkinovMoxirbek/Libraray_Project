package org.example.Service;

import org.example.DTO.Book;
import org.example.DTO.BookOrderInformation;
import org.example.DTO.StudentBook;
import org.example.DTO.User;
import org.example.Enums.Role;
import org.example.Repository.BookRepository;
import org.example.Repository.StudentBookRepository;
import org.example.Repository.UserRepository;
import org.example.Util.ScannerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class AdminService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private StudentBookRepository studentBookRepository;
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
        book.setAmount(ScannerUtil.scannerInt.nextInt());
        book.setVisible(true);
        List<Book> bookList = bookRepository.getBookList();
        for (Book b : bookList) if (b.getTitle().equals(book.getTitle()) && b.getAuthor().equals(book.getAuthor())) book.setAmount(b.getAmount() + book.getAmount());
        getResult(bookRepository.updateBook(book.getId(),book));
    }

    public void DeleteBook() {
        System.out.print("Enter Id : ");
        Integer id = ScannerUtil.scannerInt.nextInt();
        if (null != studentBookRepository.getStudentBookByBookId(id)){
            System.out.println("Sorry, this book is still in student hands, \ncan only delete the book after the book is returned to the library!");
            return;
        }
        getResult(bookRepository.deleteBook(id));
    }

    public void StudentList() {
        List<User> usersList = userRepository.getUserList();
        for(User u : usersList)if (u.getRole().equals(Role.STUDENT))System.out.println(u.toString());
    }

    public void AddStudent() {
        User user = new User();
        System.out.print("Enter name : ");
        user.setName(ScannerUtil.scannerStr.nextLine());
        System.out.print("Enter surname : ");
        user.setSurname(ScannerUtil.scannerStr.nextLine());
        String phone = ScannerUtil.getPhoneNumber();
        User temporary = userRepository.getUserByPhone(phone);
        if (temporary != null) {
            System.out.println("student is registered");
            return;
        } else if (phone == null) {
            System.out.println("Exited!");
        }
        System.out.print("Enter passsword : ");
        user.setPswd(ScannerUtil.scannerStr.nextLine());
        user.setPhone(phone);
        user.setRole(Role.STUDENT);
        user.setVisible(true);
        getResult(userRepository.save(user));
    }

    public void DeleteStudent() {
        System.out.print("Enter Id : ");
        Integer id = ScannerUtil.scannerInt.nextInt();
        getResult(userRepository.deleteUser(id));
    }

    public void StudentTakenBook() {
        List<BookOrderInformation> informations= studentBookRepository.getOrderInfoListByStudentId(null);
        for (BookOrderInformation i : informations) System.out.println("Book (Order number ='" + i.getSb_id() + "', Student name ='" + i.getStudent_name() +
                "', Student surname ='" + i.getStudent_surname() + "', Student phone ='" + i.getStudent_phone() + "', Taken date ='" + i.getTaken_time() + "' );");
    }

    public void BookTakenHistory() {
        List<BookOrderInformation> informations= studentBookRepository.getHistory();
        for (BookOrderInformation i : informations) System.out.println("Book (Order number ='" + i.getSb_id() + "', Student name ='" + i.getStudent_name() +
                "', Student surname ='" + i.getStudent_surname() + "', Student phone ='" + i.getStudent_phone() + "', Book title ='" + i.getBook_title() +
                "', Book author ='" + i.getBook_author() + "', Taken date ='" + i.getTaken_time() + "', Returned date ='" + i.getReturned_time() + "' );");

    }
    public void getResult(int n){
        if (n == 1) System.out.println("successfully!");
        else System.out.println("failed!");
    }
}
