package com.cc.campuscircle.controller;

import com.cc.campuscircle.dto.LoginRequest;
import com.cc.campuscircle.dto.RegisterRequest;
import com.cc.campuscircle.entity.User;
import com.cc.campuscircle.service.AuthService;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest){
        User user=authService.register(registerRequest.getEmail(), registerRequest.getRollNumber(),registerRequest.getPassword());
        return ResponseEntity.ok("Register success!");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request){
//        Optional<User> userOpt=userRepository.findByEmail(request.getEmail());
//        if(userOpt.isEmpty()){
//            return ResponseEntity.badRequest().body("Invalid email or password");
//        }
//        User user=userOpt.get();
//        if(!passwordEncoder.matches(request.getPassword(),user.getPassword())){
//            return ResponseEntity.badRequest().body("invalid email/password");
//        }

        authService.login(request.getEmail(),request.getPassword());
        return ResponseEntity.ok("login success");
    }

}
