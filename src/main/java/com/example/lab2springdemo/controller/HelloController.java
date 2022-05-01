package com.example.lab2springdemo.controller;

import com.example.lab2springdemo.response.GreetingResponse;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HelloController {
    private final AtomicLong counter = new AtomicLong();

    @CrossOrigin(origins = "*")
    @RequestMapping("/hello")
    public String index() {
        return "Hello, World!";
    }

    @RequestMapping("/greeting")
    public @ResponseBody GreetingResponse greeting(@RequestParam(value = "name",
    defaultValue = "World") String name) {
        return new GreetingResponse(counter.incrementAndGet(), "Hello, " + name + "!");
    }
}
