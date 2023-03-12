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
        String sql = "insert into user (id, name, surname,phone, createdDate, visible) values (%s,'%s','%s','%s',now(),%s)";
        sql = String.format(sql, user.getId(), user.getName(),user.getSurname(),user.getPhone(),user.isVisible());
        int n = jdbcTemplate.update(sql);
        System.out.println(n);
    }
    public void updateLesson(Integer userId, User user) {
        String sql = "Update user set id =%d, name ='%s', surname ='%s',phone ='%s',createdDate ='%s', visible =%s  where id = %d";
        sql = String.format(sql, user.getId(),user.getName(),user.getSurname(),user.getPhone(), user.getCreatedDate(),user.isVisible(), userId);
        int n = jdbcTemplate.update(sql);
        System.out.println(n);
    }
    public List<User> getUserList() {
        String sql = "SELECT * FROM user";
        List<User> userList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        return userList;
    }
    public int deleteUser(Integer id) {
        String sql = String.format("delete from user where id = '%s'", id);
        return jdbcTemplate.update(sql);
    }
    public User getUserById(Integer id) {
        String sql = "SELECT * FROM user where id =" + id;
        List<User> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
}
