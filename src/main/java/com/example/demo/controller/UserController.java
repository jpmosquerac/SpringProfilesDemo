package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

    @Controller	// This means that this class is a Controller
    @RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
    public class UserController {

        @Autowired
        private UserService userService;

        @PostMapping(path="/add") // Map ONLY POST Requests
        public @ResponseBody String addNewUser (@RequestParam String name
                , @RequestParam String email) {
            try{
                userService.add(name, email);
                return "saved!";
            }catch (Exception e){
                return "error!";
            }
        }

        @GetMapping(path="/all")
        public @ResponseBody Iterable<User> getAllUsers() {
            // This returns a JSON or XML with the users
            return userService.getAllUsers();
        }
    }