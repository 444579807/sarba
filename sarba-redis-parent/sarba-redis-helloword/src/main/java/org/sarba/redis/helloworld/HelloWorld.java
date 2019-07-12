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
        System.out.println("���ӳɹ���");
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

        try{
            FileInputStream fis = new FileInputStream("d:\\test.jpg");//��a.txt�ж���
            byte[] data = readInputStream(fis);
//newһ���ļ�������������ͼƬ��Ĭ�ϱ��浱ǰ���̸�Ŀ¼
            File imageFile = new File("\\\\192.168.3.110\\carnet\\test.jpg");
//���������
            FileOutputStream outStream = new FileOutputStream(imageFile);
//д������
            outStream.write(data);
//�ر������
            outStream.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        //smb://xxx:xxx@192.168.2.188/testIndex/
        String url="smb://192.168.3.110/carnet/a.txt";
       /* try {
            SmbFile smbFile = new SmbFile(url);
            int length = smbFile.getContentLength();// �õ��ļ��Ĵ�С
            byte buffer[] = new byte[length];
            SmbFileInputStream in = new SmbFileInputStream(smbFile);
            // ����smb�ļ�������
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
//����һ��Buffer�ַ���
        byte[] buffer = new byte[1024];
//ÿ�ζ�ȡ���ַ������ȣ����Ϊ-1������ȫ����ȡ���
        int len = 0;
//ʹ��һ����������buffer������ݶ�ȡ����
        while( (len=inStream.read(buffer)) != -1 ){
//���������buffer��д�����ݣ��м����������ĸ�λ�ÿ�ʼ����len�����ȡ�ĳ���
            outStream.write(buffer, 0, len);
        }
//�ر�������
        inStream.close();
//��outStream�������д���ڴ�
        return outStream.toByteArray();
    }
}
