package com.saas.Service.imp;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.saas.Ben.User;
import com.saas.Dao.UserDao;
import com.saas.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    //新增用户
    public void saveUser(User user)
    {
        userDao.save(user);

    }
    //根据username查询是否已有用户
    public User  finduser(String name)
    {
        return  userDao.findByUsername(name);
    }


    //查询所有用户信息
    public List<User> findUser()
    {
     return userDao.findAll();
    }



    //校验账号是否正确
    public User account(String name,String password)
    {
        return userDao.findByUsernameAndPassword(name,password);
    }


    //生成Token
    public String getToken(String username, String password) {
        Date date=new Date(new Date().getTime()+60000*5);
        String token = JWT.create()
                .withClaim("username", username)
                .withClaim("password", password)
                //设置token失效时间
                .withExpiresAt(date)
                //设置签名
                .sign(Algorithm.HMAC256("12306"));

        return token;

    }

    public int updateurl(String username,String path)
    {

        return userDao.updateByPricturl(username,path);
    }

}
