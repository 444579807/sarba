package org.sarba.java.basis.main.stringdemo;

public class StringDemo {

    public static void method1(String str){
        str = str + "sss";
        System.out.println(str);
    }

    public static void method2(String str){
        str = str + "aaa";
        System.out.println(str);
    }

    public static void method3(String str){
        str.intern();
    }


    public static void main(String[] args) {
        String str = new String("sss");
        method1(str);
        System.out.println(str);
        method2(str);
        System.out.println(str);
    }

}
