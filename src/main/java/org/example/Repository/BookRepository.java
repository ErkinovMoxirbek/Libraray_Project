package org.example.Repository;

import org.example.DTO.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class BookRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public void save(Book book) {
        String sql = "insert into lesson (id,title,author,publishYear,amount,visible) values ('%s','%s','%s',now(),'%s','%s')";
        sql = String.format(sql, book.getId(), book.getTitle(),book.getAuthor(),book.getAmount(),book.isVisible());
        int n = jdbcTemplate.update(sql);
        System.out.println(n);
    }
    public void updateLesson(Integer bookId, Book book) {
        String sql = "Update book set id =%d, title ='%s', author ='%s',publishYear ='%s',amount =%s, visible =%s  where id = %d";
        sql = String.format(sql, book.getId(),book.getTitle(),book.getAuthor(),book.getPublishYear(), book.getAmount(),book.isVisible(), bookId);
        int n = jdbcTemplate.update(sql);
        System.out.println(n);
    }
    public List<Book> getBookList() {
        String sql = "SELECT * FROM book";
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
}
