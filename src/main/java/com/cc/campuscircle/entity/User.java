package com.cc.campuscircle.entity;

import com.cc.campuscircle.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name="users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="email",nullable = false,unique = true)
    private String email;

    @Column(name="roll_number",nullable = false,unique = true)
    private String rollNumber;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    private Boolean enabled=true;

    @CreationTimestamp
    private LocalDateTime createdAt;


}
