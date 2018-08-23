# Tourist
该Demo基于SpringCloud  最新的Finchley SR1 和SpringBoot2.0.4.RELEASE
JDK 1.8


Tourist-register-center : 注册中心
Tourist-user-service: 用户管理微服务
    | bin 项目部署时候的脚本
    | src
        | main
            | java
                | com.sunarmy.cn
                    |Controller 
                    |Dao
                    |entity     里面放的是实体类，项目启动都会根据这个表中的实体类生成对应的表结构，故此该包下的类一般不做修改，除非遇到需要添加字段的时候
                    |service
                    |utils