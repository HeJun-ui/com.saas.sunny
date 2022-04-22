package com.saas.Dao;

import com.saas.Ben.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {

    User findByUsername(String name);
    User findByUsernameAndPassword(String name,String password);
}
