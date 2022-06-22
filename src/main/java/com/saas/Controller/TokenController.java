package com.saas.Controller;

import com.saas.Ben.Users;
import com.saas.Service.imp.UserServiceImpl;
import com.saas.Utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/token")
public class TokenController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public ResponseUtil GetToken(@RequestBody Map<String, String> map) {
        String username = map.get("username");
        String password = map.get("password");
        if (username != null && password != null) {
            Users users = userService.account(username, password);
            //校验密码是否正确 是否为管理员用户
            if (users != null && users.getIs_admin() == 2) {
                //JWT生成token
                String token = userService.getToken(username, password);
                Map message = new HashMap<>();
                message.put("username", username);
                message.put("token", token);
                //返回信息
                return new ResponseUtil().requsuccess(message);
            } else if (users == null) {
                return new ResponseUtil().requfailed("账号或密码不正确");

            } else if (users.getIs_admin() != 2) {
                return new ResponseUtil().requfailed("您不是管理员用户,没有权限查询");
            }

        }
        return new ResponseUtil().requfailed("账号密码不能为空");

    }
}
