
package com.saas.Controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.saas.Ben.User;
import com.saas.Service.imp.UserServiceImpl;
import com.saas.Utils.MessReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    /**
     * 用户注册新增用户
     *
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/insert")
    public MessReturn UserSave(String username, String password, char sex, int age, String name) {
        try {
            if (userService.finduser(username) == null) {
                User users = new User(sex, age, name, username, password);
                userService.saveUser(users);

            } else {
                return new MessReturn().requfailed("该用户名已经使用");
            }
            return new MessReturn().requsuccess("注册成功");
        } catch (Exception E) {
            E.printStackTrace();
            return new MessReturn().requfailed("失败");
        }

    }

    /**
     * 管理员查询所有用户信息
     *
     * @return
     */
    @RequestMapping("/finduser")
    public MessReturn findUser(HttpServletRequest request) {
        //获取headers头部信息
        String token = request.getHeader("Authorization");
        //验证token
        if (token != null) {
            DecodedJWT chack = null;
            try {
                chack = JWT.require(Algorithm.HMAC256("12306")).build().verify(token);
                List<User> userList = userService.findUser();
                return new MessReturn().requsuccess(userList);
            } catch (Exception e) {
                e.printStackTrace();
                return new MessReturn().requfailed("token无效");

            }
            //以json格式返回所有用户信息

        }
        return new MessReturn().requfailed("token不能为空");
    }

}
