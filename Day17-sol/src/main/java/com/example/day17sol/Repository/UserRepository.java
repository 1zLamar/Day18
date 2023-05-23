package com.example.day17sol.Repository;


import com.example.day17sol.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    @Query("select u from User u where u.username=?1 and u.password=?2")
    User check(String username,String password);

    User findUserByEmail(String email);

    List<User> findAllByRole(String role);

    List<User> findAllByAgeGreaterThanEqual(int age);

}
