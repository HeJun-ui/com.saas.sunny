package com.saas.Controller;

import com.saas.Ben.User;
import com.saas.Service.imp.UserServiceImpl;
import com.saas.Utils.MessReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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
            return new MessReturn().requfailed("注册成功");
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
        String str = request.getHeader("Authorization");
        //验证token
        if (str.equals("qqw1234")) {
            List<User> userList = userService.findUser();
            //以json格式返回所有用户信息
            return new MessReturn().requsuccess(userList);
        }
        return new MessReturn().requfailed("login username or password invalid");
    }

    @RequestMapping("/finduser2")
    public MessReturn findUsername(@RequestBody User user) {
        if (userService.finduser(user.getUsername()) == null) {
            return new MessReturn().requsuccess("账号名称不存在");
        } else {
            return new MessReturn().requfailed("账号名称已经存在");
        }
    }

}
