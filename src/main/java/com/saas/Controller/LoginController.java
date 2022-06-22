package com.saas.Controller;
import com.alibaba.fastjson.JSONObject;
import com.saas.Ben.PageInfo;
import com.saas.Ben.Post;
import com.saas.Ben.Users;
import com.saas.Service.imp.PostServiceImpl;
import com.saas.Service.imp.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    UserServiceImpl userService;

    @Autowired
    PostServiceImpl postService;

    @RequestMapping(value = "/home")
    public  String login(Model model, HttpServletRequest req)
    {
        PageInfo<Post> pageInfo= postService.queryList(0,8);
        model.addAttribute("post",pageInfo);
        return "home";

    }

    /**
     * 分页接口实现
     * @param index
     * @param model
     * @return
     */
    @RequestMapping(value ="/paging")
    public  String  paging(Integer index,Model model)
    {
        int page=index;
        PageInfo<Post> pageInfo= postService.queryList(--index,8);
        pageInfo.setIndex(page);
        model.addAttribute("post",pageInfo);
        return  "home::fragmentSegment";
    }




    }

