package com.cc.campuscircle.service.impl;

import com.cc.campuscircle.entity.User;
import com.cc.campuscircle.enums.Role;
import com.cc.campuscircle.repository.UserRepository;
import com.cc.campuscircle.service.AuthService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public User register(String email,String rollNumber,String password){
        //email
        if(!email.endsWith("@rgukt.ac.in")){
            throw new RuntimeException("only the mentioned domail allowed");
        }

        //id
        if(!rollNumber.matches("B\\d{6}")){//BXXXXXX
            throw new RuntimeException("Invalid rollnumber format");
        }
        //duplicate email
        if(userRepository.existsByEmail(email)){
            throw new RuntimeException("email is already regstered");

        }
        //duplicate rollnum
        if(userRepository.existsByRollNumber(rollNumber)){
            throw new RuntimeException("Rollnumber already exists");

        }

        //if all conditiones surpasses then create new user

        User user=new User();
        user.setEmail(email);
        user.setRollNumber(rollNumber);
        user.setRole(Role.STUDENT);
        user.setEnabled(true);
        return userRepository.save(user);
    }

    @Override
    public User login(String email, String password) {
        User user=userRepository.findByEmail(email).orElseThrow(()->new RuntimeException("invalid email or password"));
        if(!passwordEncoder.matches(password,user.getPassword())){
            throw new RuntimeException("Invalid email or password");
        }
        return user;
    }
}
