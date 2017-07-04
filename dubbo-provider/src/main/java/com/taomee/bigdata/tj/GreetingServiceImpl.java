package com.taomee.bigdata.tj;

import com.taomee.bigdata.server.GreetingServer;

import java.util.Date;

/**
 * Author looper.
 * Company  TaoMee.Inc, ShangHai.
 * Date  2017/7/4.
 */
public class GreetingServiceImpl implements GreetingServer{

    public String hello(String name) {
        System.out.println("接受到的信息为: " +name+ " "+new Date());
        String requestMessage = "hello," +name;
        return requestMessage;
    }
}
