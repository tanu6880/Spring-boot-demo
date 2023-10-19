package com.springboot.st.springbootdemo.Dao;

import com.springboot.st.springbootdemo.Entity.Login_Users;
import com.springboot.st.springbootdemo.Entity.Users;
import com.springboot.st.springbootdemo.SpringbootdemoApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component("allOperation")
public class AllOperation {

    LoginRepository loginRepository ;
    UserRepository userRepository ;
    Users users;
    Login_Users login_users;

    @Autowired
    public AllOperation(LoginRepository loginRepository, UserRepository userRepository, Login_Users login_users, Users users) {
        this.loginRepository = loginRepository;
        this.userRepository = userRepository;
        this.login_users = login_users;
        this.users = users;
    }

    public void insert_Login(String id, String username, String password)
    {
        login_users.setId(id);
        login_users.setUsername(username);
        login_users.setPassword(password);
        loginRepository.save(login_users);

    }
    public void insert_users(String id, String name, String city, String district)
    {
        users.setId(id);
        users.setName(name);
        users.setCity(city);
        users.setDistrict(district);
        userRepository.save(users);
    }

    public void findById(String id)
    {
        Optional<Login_Users> u1 = loginRepository.findById(id);
        System.out.println(u1.toString());
    }

    public void findAll()
    {
        Iterable<Users> itr = userRepository.findAll();
        itr.forEach(users1 -> System.out.println(users1.toString()));
    }

    // custom finder method/derived query method
    public void findByName(String name)
    {
        Optional<Users> u1 = userRepository.findByName(name);
        System.out.println(u1.toString());
    }

    public void findByUsernameAndPassword(String username, String password)
    {
        Optional<Login_Users> u1 = loginRepository.findByUsernameAndPassword(username,password);
        System.out.println(u1.toString());
    }

    public void findByNameStartingWith(String suffix)
    {
        Optional<Users> u1 = userRepository.findByNameStartingWith(suffix);
        System.out.println(u1.toString());
    }

    public void findByNameContaining(String words)
    {
        Iterable<Users> u1 = userRepository.findByNameContaining(words);
        System.out.println(u1.toString());
    }

    public void findByNameLike(String likepattern)
    {
        Iterable<Users> itr = userRepository.findByNameLike(likepattern);
        itr.forEach(users1 -> System.out.println(users1.toString()));
    }

    public void findByIdLessThan(String id)
    {
        Iterable<Users> u1 = userRepository.findByIdLessThan(id);
        System.out.println(u1.toString());
    }

    /*public void findByIdGraterThanEqual(String id)
    {
        Optional<Users> u1 = userRepository.findByIdGraterThanEqual(id);
        System.out.println(u1.toString());
    }

    public void findByIdIn(String id)
    {
        Optional<Users> u1 = userRepository.findByIdIn(id);
        System.out.println(u1.toString());
    }*/

    public void findByNameOrderByName(String name)
    {
        Optional<Users> u1 = userRepository.findByNameOrderByName(name);
        System.out.println(u1.toString());
    }

    public void getAll(String name)
    {
        Iterable<Users> itr = userRepository.getall(name);
        itr.forEach(users1 -> System.out.println(users1));
    }

    public void Alldata()
    {
        Iterable<Users> itr = userRepository.Alldata();
        itr.forEach(users1 -> System.out.println(users1));
    }
}
