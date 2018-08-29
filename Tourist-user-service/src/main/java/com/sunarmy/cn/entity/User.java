package com.sunarmy.cn.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by wb-wsj429645 on 2018/8/24.
 */
@Entity //声明一个实体类
@Table(name = "user")   //映射的表的名称
public class User {
    /**
     * id 唯一不重复
     * 声明主键
     * 声明主键的生成策略
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "system-uuid")
    @GenericGenerator(name = "system-uuid",strategy = "uuid.hex")
    String id;

    /**
     * 用户名
     */
    @Column(name = "username")
    String username;

    /**
     * 密码
     */
    @Column(name = "password")
    String password;

    /**
     * 盐
     */
    @Column(name = "salt")
    String salt;

    /**
     * Token
     */
    @Column(name = "token")
    String token;
    /**
     * 手机号
     */
    @Column(name = "mobile",length = 11)
    Long mobile;

    /**
     * 创建时间
     * @return
     */
    @Column(name = "create_date")
    Long createdate;

    /**
     * 最后修改时间
     */
    @Column(name = "last_modified_time")
    Long lastmodifiedtime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getMobile() {
        return mobile;
    }

    public void setMobile(Long mobile) {
        this.mobile = mobile;
    }

    public Long getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Long createdate) {
        this.createdate = createdate;
    }

    public Long getLastmodifiedtime() {
        return lastmodifiedtime;
    }

    public void setLastmodifiedtime(Long lastmodifiedtime) {
        this.lastmodifiedtime = lastmodifiedtime;
    }
}
