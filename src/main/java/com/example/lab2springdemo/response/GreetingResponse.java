package com.example.lab2springdemo.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class GreetingResponse {
    private final long id;
    private final String name;
}
