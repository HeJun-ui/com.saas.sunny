package com.saas.Controller;

import com.saas.Ben.User;
import com.saas.Service.imp.UserServiceImpl;
import com.saas.Utils.MessReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/token")
public class TokenController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/get")
    public MessReturn GetToken(@RequestBody Map<String,String> map) {
        String username=map.get("username");
        String password=map.get("password");
        if(username!=null&&password!=null)
        {
            User user=userService.account(username,password);

            if (user!=null&&user.getIs_admin()==1)
            {
                //JWT生成token
               String token= userService.gettoken(username,password);
                Map message=new HashMap<>();
                message.put("username",username);
                message.put("token",token);
                //返回信息
                return new MessReturn().requsuccess(message);
            }else if (user==null)
            {
                return new MessReturn().requfailed("账号密码不正确");
            }else if (user.getIs_admin()==0)
            {
                return new MessReturn().requfailed("您不是管理员用户");
            }
        }

        return new MessReturn().requfailed("账号密码不能为空");


    }
}
