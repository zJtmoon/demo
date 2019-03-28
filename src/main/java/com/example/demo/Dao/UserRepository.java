package com.example.demo.Dao;

import com.example.demo.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
/*
dao 只要继承 JpaRepository 类就可以，几乎可以不用写方法，还有一个特别有尿性的功能非常赞，
就是可以根据方法名来自动的生产 SQL，比如findByUserName 会自动生产一个以 userName 为参数的查询方法
，比如 findAlll 自动会查询表里面的所有数据，比如自动分页等等。。

 */
public interface UserRepository extends JpaRepository<User, Long> {
    // 红色方框字段说明：接口必须继承类型参数化为实体类型和实体类中的Id类型的Repository
//    因为本例中public interface UserRepository extends JpaRepository<T, ID>,
//
//            根据上述描述：T 需要类型化为实体类(Entity)User，ID需要实体类User中Id（我定义的Id类型是Long）的类型
//
//    故此，UserRepository接口需要写成：public interface UserRepository extends JpaRepository<User, Long>
    User findByUserName(String userName);
    User findByUserNameOrEmail(String username, String email);
}