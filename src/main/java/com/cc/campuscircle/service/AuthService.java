package com.cc.campuscircle.service;

import com.cc.campuscircle.entity.User;

public interface AuthService {
    User register(String email,String rollNumber,String password);
    User login(String email, String password);
}
