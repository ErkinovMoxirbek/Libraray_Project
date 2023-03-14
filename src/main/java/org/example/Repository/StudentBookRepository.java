package org.example.Repository;

import org.example.DTO.BookOrderInformation;
import org.example.DTO.StudentBook;
import org.example.Enums.Role;
import org.example.Enums.Status;
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
    public int updateStudentBook(Integer sb_id, StudentBook studentBook) {
        String sql = "Update student_book set id =%d,created_date ='%s',status ='%s' , returned_date ='%s',duration ='%s',student_id =%s,book_id =%s   where id = %d";
        sql = String.format(sql,sb_id,studentBook.getCreatedDate(), studentBook.getStatus(), studentBook.getReturnedDate(), studentBook.getDuration(),studentBook.getStudentId(),studentBook.getBookId() , sb_id);
        return jdbcTemplate.update(sql);
    }
    public List<StudentBook> getBookList() {
        String sql = "SELECT * FROM student_book";
        List<StudentBook> bookList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(StudentBook.class));
        return bookList;
    } public List<BookOrderInformation> getOrderInfoListByStudentId(Integer id) {
        if (id == null){
            String sql = " select sb.id as sb_id,b.id as book_id,b.title as book_title, b.author as book_author,sb.created_date as taken_time ,s.name as student_name , s.surname as student_surname, s.phone as student_phone from student_book as sb " +
                    "inner join book as b on sb.book_id = b.id " +
                    "inner join users as s on sb.student_id = s.id" +
                    " where sb.status = '" + Status.TAKEN + "' ;";

            List<BookOrderInformation> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(BookOrderInformation.class));
            return list;
        }
        String sql = " select sb.id as sb_id,b.id as book_id,b.title as book_title, b.author as book_author,sb.created_date as taken_time from student_book as sb " +
                "inner join book as b on sb.book_id = b.id where sb.student_id = " + id + " and sb.status = '" + Status.TAKEN + "' ;";
        List<BookOrderInformation> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(BookOrderInformation.class));
        return list;
    }
    public List<BookOrderInformation> getHistory(){
        String sql = " select sb.id as sb_id,b.id as book_id,b.title as book_title, b.author as book_author,sb.created_date as taken_time,sb.returned_date as returned_time ,s.name as student_name , s.surname as student_surname, s.phone as student_phone from student_book as sb " +
                "inner join book as b on sb.book_id = b.id " +
                "inner join users as s on sb.student_id = s.id where sb.status != 'TAKEN'";
        List<BookOrderInformation> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(BookOrderInformation.class));
        return list;
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
    public StudentBook getStudentBookByBookId(Integer bid,Integer sid) {
        String sql = "SELECT * FROM student_book where book_id =" + bid + " and student_id = " + sid + ");";
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
