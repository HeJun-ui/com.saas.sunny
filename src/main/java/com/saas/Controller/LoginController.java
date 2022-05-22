package com.saas.Controller;
import com.saas.Ben.Post;
import com.saas.Ben.User;
import com.saas.Service.PostService;
import com.saas.Service.imp.PostServiceImpl;
import com.saas.Service.imp.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class LoginController {
    @Autowired
    UserServiceImpl userService;

    @Autowired
    PostServiceImpl postService;

    @RequestMapping(value = "/login")
    public  String login()
    {
        return "login";
    }


    @RequestMapping(value ="/userlogin")
     public  String userlogin(String username,String password,Model model)
    {
        User user=userService.account(username,password);
        if (user!=null){
            model.addAttribute("filename",user.getPicture_url());
            model.addAttribute("name",user.getUsername());
            List<Post> postList= postService.findAll();
            model.addAttribute("post",postList);
            return "home";
        }
        model.addAttribute("errormessage","账号密码错误");
        return "login";
    }




    }

