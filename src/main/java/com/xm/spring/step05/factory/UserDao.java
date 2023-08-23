package com.xm.spring.step05.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: 小明长高高
 * @date: 2023/4/1 16:46
 **/
public class UserDao {
    private static Map<String,String> map = new HashMap<>();
    static{
        map.put("1","XM");
        map.put("2","XMM");
    }
    public String getUserById(String id){
        return map.get(id);
    }
}
