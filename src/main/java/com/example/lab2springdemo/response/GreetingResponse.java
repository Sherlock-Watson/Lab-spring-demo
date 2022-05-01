package com.example.lab2springdemo.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class GreetingResponse {
    private final long id;
    private final String name;
}
