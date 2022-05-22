package com.saas.Dao;

import com.saas.Ben.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostDao extends JpaRepository<Post,Integer> {
    Post findById(int id);

}
