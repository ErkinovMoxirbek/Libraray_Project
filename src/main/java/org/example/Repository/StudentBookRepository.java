package org.example.Repository;

import org.example.DTO.Book;
import org.example.DTO.StudentBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentBookRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public int save(StudentBook studentBook) {
        String sql = "insert into student_book (created_date,status,returned_date,duration,student_id,book_id) values (now(),'%s','%s','%s',%s,%s)";
        sql = String.format(sql, studentBook.getStatus(),studentBook.getReturnedDate(),studentBook.getDuration(),studentBook.getStudentId(),studentBook.getBookId());
        return jdbcTemplate.update(sql);
    }
    public void updateStudentBook(Integer sb_id, StudentBook studentBook) {
        String sql = "Update book set id =%d,created_date ='%s',status ='%s' , returned_date ='%s',duration ='%s',student_id =%s,book_id =%s   where id = %d";
        sql = String.format(sql,sb_id,studentBook.getCreateDate(), studentBook.getStatus(), studentBook.getReturnedDate(), studentBook.getDuration(),studentBook.getStudentId(),studentBook.getBookId() , sb_id);
        int n = jdbcTemplate.update(sql);
        System.out.println(n);
    }
    public List<StudentBook> getBookList() {
        String sql = "SELECT * FROM student_book";
        List<StudentBook> bookList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(StudentBook.class));
        return bookList;
    }
    public int deleteStudentBook(Integer id) {
        String sql = String.format("delete from student_book where id = '%s'", id);
        return jdbcTemplate.update(sql);
    }
    public StudentBook getStudentBookById(Integer id) {
        String sql = "SELECT * FROM student_book where id =" + id;
        List<StudentBook> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(StudentBook.class));
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
    public void initTable(){
        String student_book = "create table if not exists student_book (" +
                "id serial primary key," +
                "created_date timestamp," +
                "status varchar default 'TAKEN'," +
                "returned_date timestamp," +
                "duration date," +
                "student_id integer," +
                "book_id integer," +
                "foreign key (student_id) references student(id)," +
                "foreign key (book_id) references book(id))";
        jdbcTemplate.update(student_book);
    }
}
