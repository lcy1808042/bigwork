package edu.nifu.sas.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Test2 {
    public static void main(String[] args) throws IOException{
        Properties properties=new Properties();
        InputStream in = new Test().getClass().getClassLoader().getResourceAsStream("dbcpconfig.properties");
        properties.load(in);
        //System.out.println(properties.getProperty("password"));
        System.out.println(properties.getProperty("url"));
    }
}
