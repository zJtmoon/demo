package com.example.demo.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity    //Entity 中不映射成列的字段得加 @Transient(import javax.persistence.*;) 注解，不加注解也会映射成列
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id        //如果是主键id，还会用到@Id注解其中与@Id一起使用的还有另外两个注解：@GeneratedValue、@GenericGenerator
    @GeneratedValue
    private Long id;
    @Column(nullable = false, unique = true)
    private String userName;
    @Column(nullable = false)
    private String passWord;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = true, unique = true)
    private String nickName;
    @Column(nullable = false)
    private String regTime;
    public User(){
    }
    public User(String userName, String email, String passWord, String nickName, String regTime) {
        this.userName=userName;
        this.email=email;
        this.passWord=passWord;
        this.nickName=nickName;
        this.regTime=regTime;
    }

    /*
    @Column注释定义了将成员属性映射到关系表中的哪一列和该列的结构信息，属性如下：
    　　1）name：映射的列名。如：映射tbl_user表的name列，可以在name属性的上面或getName方法上面加入；
    　　2）unique：是否唯一；
    　　3）nullable：是否允许为空；
    　　4）length：对于字符型列，length属性指定列的最大字符长度；
    　　5）insertable：是否允许插入；
    　　6）updatetable：是否允许更新；
    　　7）columnDefinition：定义建表时创建此列的DDL；
    　　8）secondaryTable：从表名。如果此列不建在主表上（默认是主表），该属性定义该列所在从表的名字
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getRegTime() {
        return regTime;
    }

    public void setRegTime(String regTime) {
        this.regTime = regTime;
    }
}