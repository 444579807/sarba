package org.sarba.java.basis.main.systemenv;

import java.util.Map;
import java.util.Properties;

public class SystemEnvDemo {

    public static void main(String[] args) {
        Map<String,String> env = System.getenv();
        for (Map.Entry<String, String> entry : env.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        System.out.println("===============================================================");
        Properties properties = System.getProperties();
        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            System.out.println(entry.getKey().toString() + " : " + entry.getValue().toString());
        }
    }
}
