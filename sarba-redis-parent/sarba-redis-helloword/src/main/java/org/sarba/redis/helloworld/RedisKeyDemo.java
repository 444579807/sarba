package org.sarba.redis.helloworld;

import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * @program: sarba
 * @author: zhanght
 * @create: 2019-07-11 11:32
 * @description: redis key 相关操作
 **/
public class RedisKeyDemo  {

    public static void main(String[] args) {
        getAllKeys();
        getAllKeys("s*");
        /**
         *  key  pattern  如下
         *    *  配合一个或者多个字符
         *    ?  匹配一个字符
         *    [] 括号内或者的关系
         *    特殊符号用 \ 隔开
        **/
        getAllKeys("s[ite]te-list");
    }

    /**
     * @param
     * @return: void
     * @Author: zhanght
     * @Date: 2019/7/11
     * @Description: 获取所有key
    **/
    public static void getAllKeys(){
        Jedis jedis = JedisUtil.INSTANCE.getInstance();
        Set<String> keys = jedis.keys("*");
        for (String key : keys) {
            System.out.println(key);
        }
    }

    /**
     * @param
     * @return: void
     * @Author: zhanght
     * @Date: 2019/7/11
     * @Description: 获取符合条件的所有key
     **/
    public static void getAllKeys(String pattern){
        Jedis jedis = JedisUtil.INSTANCE.getInstance();
        Set<String> keys = jedis.keys(pattern);
        for (String key : keys) {
            System.out.println(key);
        }
    }



}
