package com.springboot.st.springbootdemo.Dao;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class UserRepositoryTest2 {

    @Autowired
    UserRepository userRepository;

    @Test
    public void exitsTest()
    {
        //Mockito.when(userRepository.existsById(1));
        Boolean result = userRepository.existsById("aa01");
        assertTrue(result);
    }

}