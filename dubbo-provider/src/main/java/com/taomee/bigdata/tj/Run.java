package com.taomee.bigdata.tj;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Author looper.
 * Company  TaoMee.Inc, ShangHai.
 * Date  2017/7/4.
 */
public class Run {

    public static void main(String[] args) {
        ApplicationContext context;
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        applicationContext.start();
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
