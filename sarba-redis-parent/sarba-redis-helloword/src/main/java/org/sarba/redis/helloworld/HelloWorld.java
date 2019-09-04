package org.sarba.redis.helloworld;

import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileInputStream;
import redis.clients.jedis.Jedis;

import java.io.*;
import java.net.MalformedURLException;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: sarba
 * @author: zhanght
 * @create: 2019-07-09 11:31
 * @description:
 **/
public class HelloWorld {


    public static void main(String[] args) throws Exception {
        /*Jedis jedis = new Jedis("127.0.0.1");
        System.out.println("连接成功！");
        jedis.auth("111111");
        jedis.set("name","zht");
        System.out.println("redis �洢�ַ���Ϊ��" + jedis.get("name"));
        jedis.lpush("site-list", "Runoob");
        jedis.lpush("site-list", "Google");
        jedis.lpush("site-list", "Taobao");

        List<String> list = jedis.lrange("site-list", 0 ,2);
        for(int i=0; i<list.size(); i++) {
            System.out.println("�б���Ϊ: "+list.get(i));
        }*/
        ConcurrentHashMap<String, TimerTask> taskMap = new ConcurrentHashMap<String, TimerTask>();
        Timer timer = new Timer();
        String test = "ddd";
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("time :" + new Date() + " ; name : " + test);
            }
        };
        TimerTask timerTask2 = new TimerTask() {
            @Override
            public void run() {
                System.out.println("time :" + new Date() + " ; name 2: " + test);
            }
        };
        timer.schedule(timerTask2, 1000, 1000);
        timer.schedule(timerTask, 1000, 1000);
        taskMap.put("a",timerTask);
        taskMap.put("b",timerTask2);
        Thread.sleep(4000);
        timerTask.cancel();
        timer.purge();
        if(taskMap.containsKey("a")){
            taskMap.remove("a");
        }
        System.out.println(taskMap.size());
        timerTask2.cancel();
        System.out.println(timer.purge());
        Thread.sleep(4000);

        System.out.println(timer.purge());

    }

}
