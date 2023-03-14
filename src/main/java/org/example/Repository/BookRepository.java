package org.example.Repository;

import org.example.DTO.Book;
import org.example.Enums.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class BookRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public int save(Book book) {
        String sql = "insert into book (title,author,publishYear,amount,visible) values ('%s','%s',now(),%s,%s)";
        sql = String.format(sql,  book.getTitle(),book.getAuthor(),book.getAmount(),book.isVisible());
        return jdbcTemplate.update(sql);
    }
    public int updateBook(Integer bookId, Book book) {
        String sql = "Update book set id =%d, title ='%s', author ='%s',publishYear ='%s',amount =%s, visible =%s  where id = %d";
        sql = String.format(sql, book.getId(),book.getTitle(),book.getAuthor(),book.getPublishYear(), book.getAmount(),book.isVisible(), bookId);
        return jdbcTemplate.update(sql);
    }
    public List<Book> getBookList() {
        String sql = "SELECT * FROM book";
        List<Book> bookList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Book.class));
        return bookList;
    }
    public List<Book> getBookListByStudentIdAndStatus(Integer id, Status status) {
        if (status == null){
            String sql = "SELECT * FROM book where id in (select book_id from student_book where student_id = " + id + " );" ;
            List<Book> bookList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Book.class));
            return bookList;
        }
        String sql = "SELECT * FROM book where id in (select book_id from student_book where student_id = " + id + " and status = '"+status.toString()+"' );" ;
        List<Book> bookList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Book.class));
        return bookList;
    }
    public int deleteBook(Integer id) {
        String sql = String.format("delete from book where id = '%s'", id);
        return jdbcTemplate.update(sql);
    }
    public Book getBookById(Integer id) {
        String sql = "SELECT * FROM book where id =" + id;
        List<Book> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Book.class));
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
    public void initTable(){
        String book = "drop table book cascade ;create table if not exists book (" +
                "id serial primary key," +
                "title varchar not null," +
                "author varchar not null," +
                "publishYear date not null," +
                "amount numeric," +
                "visible boolean default true)";
        jdbcTemplate.update(book);
    }
}
