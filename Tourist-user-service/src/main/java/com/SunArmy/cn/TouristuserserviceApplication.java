package com.SunArmy.cn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by wb-wsj429645 on 2018/8/23.
 */
@SpringBootApplication
@EnableEurekaClient
public class TouristuserserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TouristuserserviceApplication.class,args);
    }
}
