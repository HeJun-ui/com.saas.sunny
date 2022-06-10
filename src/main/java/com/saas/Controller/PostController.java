package com.saas.Controller;
import com.alibaba.fastjson.JSONObject;
import com.saas.Ben.Post;
import com.saas.Service.imp.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostServiceImpl postService;

     @RequestMapping(value = "/save",method = RequestMethod.POST)
    public JSONObject SavePost(@RequestBody Post post)
    {
       return postService.SavePost(post);
    }


    @RequestMapping(value = "/del")
    public String del()
    {

        return "<h1>网站正在维护</h1>";
    }
}
