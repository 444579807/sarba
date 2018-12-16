package org.sarba.java.basis.main.intdemo;

public class IntDemo  {

    public static void main(String[] args) {
        int  i1 = 100;
        int  i2 = 128;
        int  i3 = 128;
        Integer integer1 = 100;
        Integer integer2 = 128;
        Integer integer3 = 128;
        Integer neInt1 = new Integer(100);
        Integer neInt2 = new Integer(128);
        Integer neInt3 = new Integer(128);

        System.out.println(i1 == integer1);
        System.out.println(i1 == neInt1);
        System.out.println(integer1 == neInt1);
        System.out.println(integer1.equals(neInt1));
        System.out.println("============================");
        System.out.println(i2 == i3);
        System.out.println(integer2==integer3);
        System.out.println(neInt2 == neInt3);
        System.out.println(neInt2.equals(neInt3));
        System.out.println("============================");
        System.out.println(i2==integer2);
        System.out.println(i2==neInt2);



    }

}
