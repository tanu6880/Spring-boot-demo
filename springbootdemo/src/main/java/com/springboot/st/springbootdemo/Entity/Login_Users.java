package com.springboot.st.springbootdemo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.stereotype.Component;

@Component("login_Users")
@Entity
public class Login_Users {
    @Id
    private String id;
    private String username;
    private String password;

    public Login_Users(String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Login_Users() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Login_Users{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
