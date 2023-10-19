package com.springboot.st.springbootdemo.Dao;
import com.springboot.st.springbootdemo.Entity.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<Users,String> {

    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM Users u WHERE u.id = :id")
    boolean existsById(@Param("id") String id);

    Optional<Users> findByName(String name);

    Optional<Users> findByNameStartingWith(String suffix);

   

    //Optional<Users> findByNameLike(String likepattern);

   

    //Optional<Users> findByIdGraterThanEqual(String id);

    //Optional<Users> findByIdIn(String id);

    Optional<Users> findByNameOrderByName(String name);

    Iterable<Users> findByNameLike(String likepattern);

    Iterable<Users> findByIdLessThan(String id);

    @Query("select u from Users u where u.name = :name")
    Iterable<Users> getall(@Param("name") String name);

    Iterable<Users> findByNameContaining(String words);

    @Query(value = "select * from Users " , nativeQuery = true)
    Iterable<Users> Alldata();
}
