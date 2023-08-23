package com.xm.spring.step05.factory;

/**
 * @description:
 * @author: 小明长高高
 * @date: 2023/3/29 22:25
 **/
public class UserService {
    private String id;
    private UserDao userDao;
    public void queryById(){
        System.out.println("查询用户数据·····" + userDao.getUserById(id));
    }
}
