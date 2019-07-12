package org.sarba.redis.helloworld;

import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileInputStream;
import redis.clients.jedis.Jedis;

import java.io.*;
import java.net.MalformedURLException;
import java.util.List;

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
        System.out.println("redis 存储字符串为：" + jedis.get("name"));
        jedis.lpush("site-list", "Runoob");
        jedis.lpush("site-list", "Google");
        jedis.lpush("site-list", "Taobao");

        List<String> list = jedis.lrange("site-list", 0 ,2);
        for(int i=0; i<list.size(); i++) {
            System.out.println("列表项为: "+list.get(i));
        }*/

        try{
            FileInputStream fis = new FileInputStream("d:\\test.jpg");//从a.txt中读出
            byte[] data = readInputStream(fis);
//new一个文件对象用来保存图片，默认保存当前工程根目录
            File imageFile = new File("\\\\192.168.3.110\\carnet\\test.jpg");
//创建输出流
            FileOutputStream outStream = new FileOutputStream(imageFile);
//写入数据
            outStream.write(data);
//关闭输出流
            outStream.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        //smb://xxx:xxx@192.168.2.188/testIndex/
        String url="smb://192.168.3.110/carnet/a.txt";
       /* try {
            SmbFile smbFile = new SmbFile(url);
            int length = smbFile.getContentLength();// 得到文件的大小
            byte buffer[] = new byte[length];
            SmbFileInputStream in = new SmbFileInputStream(smbFile);
            // 建立smb文件输入流
            while ((in.read(buffer)) != -1) {

                System.out.write(buffer);
                System.out.println();
                System.out.println(buffer.length);
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
*/

    }

    public static byte[] readInputStream(InputStream inStream) throws Exception{
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
//创建一个Buffer字符串
        byte[] buffer = new byte[1024];
//每次读取的字符串长度，如果为-1，代表全部读取完毕
        int len = 0;
//使用一个输入流从buffer里把数据读取出来
        while( (len=inStream.read(buffer)) != -1 ){
//用输出流往buffer里写入数据，中间参数代表从哪个位置开始读，len代表读取的长度
            outStream.write(buffer, 0, len);
        }
//关闭输入流
        inStream.close();
//把outStream里的数据写入内存
        return outStream.toByteArray();
    }
}
