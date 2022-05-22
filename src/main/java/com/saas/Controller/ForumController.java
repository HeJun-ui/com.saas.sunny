package com.saas.Controller;
import com.saas.Ben.Post;
import com.saas.Ben.Remark;
import com.saas.Service.imp.PostServiceImpl;
import com.saas.Service.imp.RemarkServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ForumController {

     @Autowired
    PostServiceImpl postService;
    @Autowired
    RemarkServiceImpl remarkService;

     @RequestMapping("/findpost")
     public  String  findForum(int id,Model model)
     {
         //获取文章信息
        Post post= postService.findById(id);
        //文章对应评论
        List<Remark> remarkList=remarkService.findRemark(id);
        model.addAttribute("post",post);
        model.addAttribute("listremark",remarkList);
         return "forum";
     }



}
