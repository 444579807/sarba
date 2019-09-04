package org.sarba.java.basis.main.ioDemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @program: sarba
 * @author: zhanght
 * @create: 2019-08-13 15:05
 * @description: java 字节流
 **/
public class CopyBytes {

    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;

        try {
            inputStream = new FileInputStream("D:\\demo.txt");
            outputStream = new FileOutputStream("D:\\demoout.txt");
            int c;
            while ((c=inputStream.read()) != -1){
                outputStream.write(c);
            }
        } finally {
            if(inputStream!= null){
                inputStream.close();
            }
            if(outputStream != null){
                outputStream.close();
            }
        }
    }

}
