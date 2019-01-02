package org.sarba.java.design.factory;

public class Main {

    public static void main(String[] args) {
        ProgrammerFactory factory = new ProgrammerFactory();
        factory.getProgrammer("java").language();
        factory.getProgrammer("python").language();
        factory.getProgrammer("php").language();
    }

}
