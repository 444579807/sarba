package org.sarba.java.basis.main.stringdemo;

public class StringDemo {

    public static void method1(String str){
        str = str + "sss";
        System.out.println(str);
    }

    public static void method2(String str){
        str = "aaa";
        System.out.println(str);
    }

    public static void method3(String str){
        str.intern();
    }


    public static void main(String[] args) {
        String str = new String("sss");
        String str1 = "sss";
        //method1(str);17025d8108b

        System.out.println(str1);
        method2(str1);
        System.out.println(str1);


    }

}
