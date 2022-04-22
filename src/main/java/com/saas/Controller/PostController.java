package com.saas.Controller;

import com.saas.Ben.Post;
import com.saas.Service.imp.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostServiceImpl postService;

     @RequestMapping("/save")
    public Map<Integer,String> SavePost(@RequestBody Post post,Map map)
    {
        map=new HashMap();
       return postService.SavePost(post,map);




    }

}
