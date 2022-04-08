package com.saas.Service;

import com.saas.Ben.User;

import java.util.List;

public interface UserService {

    public void saveUser(User user);


    public List<User> findUser();
}
