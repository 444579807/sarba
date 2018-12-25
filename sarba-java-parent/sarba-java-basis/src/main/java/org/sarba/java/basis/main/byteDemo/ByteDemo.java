package org.sarba.java.basis.main.byteDemo;

public class ByteDemo {

    public static void main(String[] args) {
        byte b = -128;
        Byte bb = new Byte("8");
        Byte bbb = -1 ;
        System.out.println(b == bb);
        System.out.println(b == bbb);
        System.out.println(bbb == bb);
        System.out.println("============================");
        System.out.println("0x" + Long.toHexString(Byte.toUnsignedLong(b)));
        System.out.println("0x" + Long.toHexString(Byte.toUnsignedInt(bbb)));
        System.out.println("============================");

        byte[] bytes = {1,34,-56};
        for (int i = 0; i <bytes.length ; i++) {
            System.out.print("0x" + Long.toHexString(Byte.toUnsignedLong(bytes[i]))+"  ");
        }


    }

}
