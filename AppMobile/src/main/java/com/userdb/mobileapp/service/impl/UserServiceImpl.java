package com.userdb.mobileapp.service.impl;

import com.userdb.mobileapp.entity.UserEntity;
import com.userdb.mobileapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.userdb.mobileapp.service.IUserService;

import java.util.List;
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }
}
