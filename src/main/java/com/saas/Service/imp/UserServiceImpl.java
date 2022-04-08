package com.saas.Service.imp;
import com.saas.Ben.User;
import com.saas.Dao.UserRepository;
import com.saas.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
