package com.SunArmy.cn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by wb-wsj429645 on 2018/8/21.
 */
@SpringBootApplication
@EnableEurekaServer  //启动一个服务注册中心提供给其他应用进行对话
public class TouristRegisterCenter {
    public static void main(String[] args) {
        SpringApplication.run(TouristRegisterCenter.class, args);
    }
}