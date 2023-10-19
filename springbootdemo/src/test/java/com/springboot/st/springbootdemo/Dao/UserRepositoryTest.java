package com.springboot.st.springbootdemo.Dao;

import com.springboot.st.springbootdemo.Entity.Users;
import com.springboot.st.springbootdemo.Services.StudentServices;
import com.springboot.st.springbootdemo.Student;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    Users users ;

    @BeforeEach
    void setUp()
    {
        users.setId("aa01");
        users.setName("Himanshu Saini");
        users.setCity("baner");
        users.setDistrict("Maharasht");
    }


    @Test
    public void insert()
    {
        userRepository.save(users);
        boolean result = userRepository.existsById(users.getId());
        assertTrue(result);
    }

    @AfterEach
    void deleteData()
    {
        userRepository.deleteById(users.getId());
    }


}