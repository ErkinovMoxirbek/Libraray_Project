package org.example.Repository;

import org.example.DTO.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public class UserRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public void save(User user) {
        String sql = "insert into users (id, name, surname,phone, pswd,createdDate,role , visible) values (%s,'%s','%s','%s',now(),%s,%s)";
        sql = String.format(sql, user.getId(), user.getName(),user.getSurname(),user.getPhone(),user.getRole(),user.isVisible());
        int n = jdbcTemplate.update(sql);
        System.out.println(n);
    }
    public void updateLesson(Integer userId, User user) {
        String sql = "Update users set id =%d, name ='%s', surname ='%s',phone ='%s',pswd = '%s',createdDate ='%s',role ='%s', visible =%s  where id = %d";
        sql = String.format(sql, user.getId(),user.getName(),user.getSurname(),user.getPhone(),user.getPswd(), user.getCreatedDate(),user.isVisible(), userId);
        int n = jdbcTemplate.update(sql);
        System.out.println(n);
    }
    public List<User> getUserList() {
        String sql = "SELECT * FROM users";
        List<User> userList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        return userList;
    }
    public int deleteUser(Integer id) {
        String sql = String.format("delete from user where id = '%s'", id);
        return jdbcTemplate.update(sql);
    }
    public User getUserById(Integer id) {
        String sql = "SELECT * FROM users where id =" + id;
        List<User> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    } public User getUserByPhone(String phone) {
        String sql = "SELECT * FROM users where phone ='" + phone + "';" ;
        List<User> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
    public void initTable(){


        String users = "drop table users ;create table if not exists users (" +
                "id serial primary key," +
                "name varchar(15) not null," +
                "surname varchar(15) not null," +
                "phone varchar(13) not null," +
                "pswd varchar not null,"+
                "created_date date not null," +
                "role varchar not null,"+
                "visible boolean default true)";


        jdbcTemplate.update(users);
    }
}
