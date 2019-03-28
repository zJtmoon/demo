package com.example.demo;

import com.example.demo.Dao.UserRepository;
import com.example.demo.Server.UserImp;
import com.example.demo.pojo.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserImp userImp;
    @Test
    public void contextLoads() {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String formattedDate = dateFormat.format(date);

//        userRepository.save(new User("aa1", "aa@126.com", "aa", "aa123456",formattedDate));
//        userRepository.save(new User("bb2", "bb@126.com", "bb", "bb123456",formattedDate));
//        userRepository.save(new User("cc3", "cc@126.com", "cc", "cc123456",formattedDate));

//        Assert.assertEquals(3, userRepository.findAll().size());
        System.out.println("==========================================================================");
        Assert.assertEquals("bb123456", userRepository.findByUserNameOrEmail("bb2", "bb@126.com").getNickName());
        System.out.println("==========================================================================");
        userRepository.delete(userRepository.findByUserName("aa1"));
    }
    @Test
    public  void Test1(){
        userImp.findByUserName("xxxx");
    }

}
