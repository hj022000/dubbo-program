package com.taomee.bigdata.tj;

import com.taomee.bigdata.server.GreetingServer;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author looper.
 * Company  TaoMee.Inc, ShangHai.
 * Date  2017/7/4.
 */
public class ConsumerRun {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        GreetingServer greetingServer = (GreetingServer) applicationContext.getBean("greetingServer");
       /* String s = greetingServer.hello("looper");
        System.out.println("msg:" +s);*/
        for(int i =0 ; i<10; i++)
        {
            System.out.println(greetingServer.hello(String.valueOf(i)));
            try {
                Thread.sleep(1000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
