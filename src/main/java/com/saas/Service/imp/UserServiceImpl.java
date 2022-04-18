package com.saas.Service.imp;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.saas.Ben.User;
import com.saas.Dao.UserRepository;
import com.saas.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    //新增用户
    public void saveUser(User user)
    {
    userRepository.save(user);

    }
    //根据username查询是否已有用户
    public User  finduser(String name)
    {
        return  userRepository.findByUsername(name);
    }


    //查询所有用户信息
    public List<User> findUser()
    {
     return userRepository.findAll();
    }

    //校验账号是否正确
    public User account(String name,String password)
    {
        return userRepository.findByUsernameAndPassword(name,password);
    }

    //生成Token
    public String gettoken(String username, String password) {
        Date date=new Date(new Date().getTime()+60000*5);
        String token = JWT.create()
                .withClaim("username", username)
                .withClaim("password", password)
                .withExpiresAt(date)
                //设置签名
                .sign(Algorithm.HMAC256("12306"));

        return token;

    }

}
