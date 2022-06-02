package com.saas.Service;

import com.saas.Ben.Post;

import java.util.List;

public interface PostService {

     List<Post> findAll();

     

     public Post findById(int id);



}
