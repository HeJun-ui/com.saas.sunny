
package com.saas.Controller;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.saas.Ben.User;
import com.saas.Service.imp.UserServiceImpl;
import com.saas.Utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    public ResponseUtil UserSave(String username, String password, char sex, int age, String name) {
        try {
            if (userService.finduser(username) == null) {
                User users = new User(sex, age, name, username, password);
                userService.saveUser(users);
            } else {
                return new ResponseUtil().requfailed("该用户名已经使用");
            }
                return new ResponseUtil().requsuccess("注册成功");
        } catch (Exception E) {
            E.printStackTrace();
                return new ResponseUtil().requfailed("失败");
        }

    }

    /**
     * 管理员查询所有用户信息
     *
     * @return
     */
    @RequestMapping("/finduser")
    public ResponseUtil findUser(HttpServletRequest request, HttpServletResponse response) {

        //获取headers头部信息
        String token = request.getHeader("Authorization");
        //验证token
        if (token != null) {
            DecodedJWT chack = null;
            try {
                chack = JWT.require(Algorithm.HMAC256("12306")).build().verify(token);
                List<User> userList = userService.findUser();
                return new ResponseUtil().requsuccess(userList);
            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseUtil().requfailed("token无效");
            }
            //以json格式返回所有用户信息
             }
                return new ResponseUtil().requfailed("token不能为空");
    }

}
