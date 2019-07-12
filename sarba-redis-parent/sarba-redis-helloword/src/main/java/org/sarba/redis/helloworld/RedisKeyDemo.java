package org.sarba.redis.helloworld;

import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * @program: sarba
 * @author: zhanght
 * @create: 2019-07-11 11:32
 * @description: redis key ��ز���
 **/
public class RedisKeyDemo  {

    public static void main(String[] args) {
        getAllKeys();
        getAllKeys("s*");
        /**
         *  key  pattern  ����
         *    *  ���һ�����߶���ַ�
         *    ?  ƥ��һ���ַ�
         *    [] �����ڻ��ߵĹ�ϵ
         *    ��������� \ ����
        **/
        getAllKeys("s[ite]te-list");
    }

    /**
     * @param
     * @return: void
     * @Author: zhanght
     * @Date: 2019/7/11
     * @Description: ��ȡ����key
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
     * @Description: ��ȡ��������������key
     **/
    public static void getAllKeys(String pattern){
        Jedis jedis = JedisUtil.INSTANCE.getInstance();
        Set<String> keys = jedis.keys(pattern);
        for (String key : keys) {
            System.out.println(key);
        }
    }



}
