package com.springboot.st.springbootdemo.Dao;

import com.springboot.st.springbootdemo.Entity.Login_Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepository extends CrudRepository<Login_Users,String> {

    Optional<Login_Users> findByUsernameAndPassword(String username, String password);
}
