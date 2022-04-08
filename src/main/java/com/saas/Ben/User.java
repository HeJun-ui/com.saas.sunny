package com.saas.Ben;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    //用户昵称
    @Column(name = "name")
    private String name;
    //年龄
    @Column(name = "age")
    private int age;
    //用户登录名称
    @Column(name = "username")
    private String username;
    //用户密码
    @Column(name = "password")
    private String password;
    //性别
    @Column(name = "sex")
    private char sex;
    //权限
    @Column(name = "is_admin")
    private int is_admin;




    public void setIs_admin(int is_admin) { this.is_admin = is_admin; }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) { this.password = password; }
    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public char getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }


    //public int getIs_admin() {  return is_admin; }
    /*public String getPassword() {
        return password;
    }*/

    /*public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }*/


    public User() {

    }

    public User(char sex, int age, String name, String username, String password) {
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.age = age;
        this.name = name;

    }

    public String toString() {
        return "Users [userid=" + id + ", username=" + name + ", userage=" + age + "]";
    }

}
