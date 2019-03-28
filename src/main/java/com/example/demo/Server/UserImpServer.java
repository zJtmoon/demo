package com.example.demo.Server;

import com.example.demo.Dao.UserRepository;
import com.example.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserImpServer implements UserImp {
    @Autowired
    UserRepository userRepository;
    @Override
//    @Cacheable(value="common1")
    @CacheEvict(value="common1")

    public User findByUserName(String userName) {
        System.out.println("==========================================================");
        System.out.println("==========================================================");
        return userRepository.findByUserName(userName);
    }

    @Override
    public User findByUserNameOrEmail(String username, String email) {
        return null;
    }
}
