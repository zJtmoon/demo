package com.example.demo.Server;

import com.example.demo.pojo.User;

public interface UserImp {
    User findByUserName(String userName);
    User findByUserNameOrEmail(String username, String email);
}
