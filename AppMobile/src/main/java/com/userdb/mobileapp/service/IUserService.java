package com.userdb.mobileapp.service;

import com.userdb.mobileapp.entity.UserEntity;

import java.util.List;

public interface IUserService {
    List<UserEntity> getAllUsers();
}
