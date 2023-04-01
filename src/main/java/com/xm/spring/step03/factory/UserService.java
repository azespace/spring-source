package com.xm.spring.step03.factory;

/**
 * @description:
 * @author: 小明长高高
 * @date: 2023/3/29 22:25
 **/
public class UserService {
    private Integer i = 0;
    UserService (Integer i){
        this.i = i;
    }
    public void queryById(){
        System.out.println("查询用户数据·····" + i);
    }
}
