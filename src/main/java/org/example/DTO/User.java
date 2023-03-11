package org.example.DTO;

import org.example.Enums.Role;

import java.time.LocalDateTime;

public class User {
    private Integer id;
    private String name;
    private String surname;
    private String phone;
    private String pswd;
    private LocalDateTime createdDate;
    private boolean visible;
    private Role role ;

    public User() {
    }

    public User(Integer id, String name, String surname, String phone, String pswd, LocalDateTime createdDate, boolean visible, Role role) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.pswd = pswd;
        this.createdDate = createdDate;
        this.visible = visible;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", pswd='" + pswd + '\'' +
                ", createdDate=" + createdDate +
                ", visible=" + visible +
                ", role=" + role +
                '}';
    }
}
