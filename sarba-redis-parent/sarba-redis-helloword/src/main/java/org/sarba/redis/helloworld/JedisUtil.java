package org.sarba.redis.helloworld;

import redis.clients.jedis.Jedis;

/**
 * @program: sarba
 * @author: zhanght
 * @create: 2019-07-09 11:53
 * @description:
 **/
public enum  JedisUtil {

    INSTANCE;

    private Jedis jedis = null;

    public Jedis getInstance(){
        if(jedis == null){
            jedis = new Jedis("127.0.0.1");
            jedis.auth("111111");
        }
        return jedis;
    }

}
