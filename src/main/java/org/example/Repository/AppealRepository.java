package org.example.Repository;

import org.example.DTO.Book;
import org.example.DTO.StudentAppeal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppealRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public int save(StudentAppeal appeal) {
        String sql = "insert into appeals (student_id,appeal_text,created_date) values (%s,'%s',now())";
        sql = String.format(sql,  appeal.getStudent_id(),appeal.getAppeal_text());
        return jdbcTemplate.update(sql);
    }
    public List<StudentAppeal> getList() {
        String sql = "SELECT * FROM appeals";
        List<StudentAppeal> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(StudentAppeal.class));
        return list;
    }
    public void initTable(){
        String book = "create table if not exists appeals (" +
                "id serial primary key," +
                "student_id integer not null," +
                "appeal_text text not null," +
                "created_date date not null);";
        jdbcTemplate.update(book);
    }
}
