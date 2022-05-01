package com.example.lab2springdemo.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRegisterRequest {
    private String username;
    private String password;
    private String email;
    private String phone;
}
