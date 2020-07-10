package com.wrh.swaggertest.service;

import com.wrh.swaggertest.model.User;
import com.wrh.swaggertest.model.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wrh
 * @version 1.0
 * @date 2020/7/10 9:11
 * @describe
 */
@Slf4j
@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    public User getById(Integer id) {
        User user = userRepository.findById(id).orElse(null);
        log.debug("ID为：{}，查询用户结果为：{}", id, user);
        return user;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

}
