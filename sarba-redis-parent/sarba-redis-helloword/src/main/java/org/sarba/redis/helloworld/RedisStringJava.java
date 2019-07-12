package org.sarba.redis.helloworld;

import redis.clients.jedis.Jedis;

/**
 * @program: sarba
 * @author: zhanght
 * @create: 2019-07-09 14:44
 * @description:
 **/
public class RedisStringJava {

    public static void main(String[] args) {
        Jedis jedis = JedisUtil.INSTANCE.getInstance();
        jedis.set("name","test");
        //�ж�key�Ƿ����
        System.out.println(jedis.exists("name"));
        //����֮��ɾ��key
        jedis.expireAt("name",1562659512);
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //�ж�key�Ƿ����
        System.out.println(jedis.exists("name"));
        System.out.println("name ��ֵ��" + jedis.get("name"));

    }

}
