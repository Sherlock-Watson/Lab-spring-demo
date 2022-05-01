package com.example.lab2springdemo.controller;

import com.example.lab2springdemo.mybatis.SqlSessionLoader;
import com.example.lab2springdemo.mybatis.po.User;
import com.example.lab2springdemo.request.UserLoginRequest;
import com.example.lab2springdemo.request.UserRegisterRequest;
import com.example.lab2springdemo.response.ErrorResponse;
import com.example.lab2springdemo.response.UserResponse;
import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public @ResponseBody Object register(UserRegisterRequest request) throws
            IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        User user = sqlSession.selectOne("adweb.lab2.UserMapper.findUserByUsername",
                request.getUsername());
        if (user != null) {
            sqlSession.close();
            return new ErrorResponse("The username is already used");
        } else {
            sqlSession.insert("adweb.lab2.UserMapper.addUser", new
                    User(request.getUsername(), request.getPassword(), request.getEmail(),
                    request.getPhone()));
            sqlSession.commit();
            sqlSession.close();
            return new UserResponse("abc"); // use your generated token here.
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody Object login(UserLoginRequest request) throws
            IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        User user = sqlSession.selectOne("adweb.lab2.UserMapper.findUserByUsername",
                request.getUsername());
        if (user == null) {
            sqlSession.close();
            return new ErrorResponse("The username does not exist.");
        } else {
            return new UserResponse("login success"); // use your generated token here.
        }
    }

    @RequestMapping(value = "/list")
    public @ResponseBody Object list() throws
            IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        return sqlSession.<User>selectList("adweb.lab2.UserMapper.findAllUsers");
    }

}
