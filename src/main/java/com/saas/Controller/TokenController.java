package com.saas.Controller;

import com.saas.Ben.User;
import com.saas.Service.imp.UserServiceImpl;
import com.saas.Utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/token")
public class TokenController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/get")
    public ResponseUtil GetToken(@RequestBody Map<String,String> map) {
        String username=map.get("username");
        String password=map.get("password");
        if(username!=null&&password!=null)
        {
            User user=userService.account(username,password);
                //校验密码是否正确 是否为管理员用户
            if (user!=null&&user.getIs_admin()==2)
            {
                //JWT生成token
               String token= userService.getToken(username,password);
                Map message=new HashMap<>();
                message.put("username",username);
                message.put("token",token);
                //返回信息
                return new ResponseUtil().requsuccess(message);
            }else if (user==null)
            {

                return new ResponseUtil().requfailed("账号或密码不正确");

            }else if (user.getIs_admin()==0)
            {

                return new ResponseUtil().requfailed("您不是管理员用户,没有权限查询");
            }
        }
                return new ResponseUtil().requfailed("账号密码不能为空");

    }
}
