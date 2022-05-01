package com.example.lab2springdemo.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@AllArgsConstructor
@Getter
public class ErrorResponse {
    String message;
}
