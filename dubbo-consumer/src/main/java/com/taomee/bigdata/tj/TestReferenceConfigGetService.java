package com.taomee.bigdata.tj;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.utils.ReferenceConfigCache;
import com.taomee.bigdata.server.GreetingServer;

/**
 * Author looper.
 * Company  TaoMee.Inc, ShangHai.
 * Date  2017/7/24.
 */
public class TestReferenceConfigGetService {

    public static void main(String[] args) {
        ApplicationConfig application = new ApplicationConfig();
        application.setName("referenceConfig");
        // 连接注册中心配置
        RegistryConfig registry = new RegistryConfig();
        registry.setProtocol("zookeeper");
        registry.setAddress("10.1.1.225:2181");

        // 注意：ReferenceConfig为重对象，内部封装了与注册中心的连接，以及与服务提供方的连接
        // 引用远程服务
        ReferenceConfig<GreetingServer> reference = new ReferenceConfig<GreetingServer>(); // 此实例很重，封装了与注册中心的连接以及与提供者的连接，请自行缓存，否则可能造成内存和连接泄漏
        reference.setApplication(application);
        reference.setRegistry(registry); // 多个注册中心可以用setRegistries()
        //reference.setRegistries();
        reference.setInterface(GreetingServer.class);
        /**
         * 本地缓存
         */
        ReferenceConfigCache cache = ReferenceConfigCache.getCache();
        GreetingServer greetingServer = cache.get(reference);
        String s = greetingServer.hello("abc_Test");
        System.out.println(s);

        /**
         * 消除缓存，释放对应资源
         */
        ReferenceConfigCache cache2 = ReferenceConfigCache.getCache();
        cache2.destroy(reference);
    }
}
