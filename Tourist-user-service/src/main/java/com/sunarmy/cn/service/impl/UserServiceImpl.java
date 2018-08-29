package com.sunarmy.cn.service.impl;

import com.sunarmy.cn.dao.UserRepository;
import com.sunarmy.cn.entity.User;
import com.sunarmy.cn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

/**
 * Created by wb-wsj429645 on 2018/8/24.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public User insertUser(User user) {
        User save = userRepository.save(user);
        return save;
    }

    @Override
    public User findByUsername(String username) {
        User user = userRepository.findByUsername(username);
        return user;
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        User user = userRepository.findUserByUsernameAndPassword(username, password);
        return user;
    }
}
