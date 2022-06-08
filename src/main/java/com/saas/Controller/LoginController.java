package com.saas.Controller;
import com.saas.Ben.PageInfo;
import com.saas.Ben.Post;
import com.saas.Ben.User;
import com.saas.Service.imp.PostServiceImpl;
import com.saas.Service.imp.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
            //List<Post> postList= postService.findAll();
            int number=postService.countpost();

            PageInfo<Post> pageInfo= postService.queryList(0,8);
            model.addAttribute("post",pageInfo);
            return "home";
        }
        model.addAttribute("errormessage","账号密码错误");
        return "login";
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

