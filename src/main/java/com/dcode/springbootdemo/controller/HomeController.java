package com.dcode.springbootdemo.controller;

import com.dcode.springbootdemo.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {
    @RequestMapping("/")
    public String home() {
        return "Hello world";
    }

    //    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @GetMapping("/user")
    public User user() {
        User user = new User();
        user.setId("1");
        user.setName("Dhairya");
        user.setEmailId("dhairya@gmail.com");
        return user;
    }

    @GetMapping("/{id}/{id2}")
    public String pathVariable(@PathVariable String id,
                               @PathVariable("id2") String name) {
        return id + "--" + name;
    }

    @GetMapping("/reqParam")
    public String reqParam(@RequestParam String name,
                           @RequestParam(name = "email", required = false, defaultValue = "") String emailId) {
        return "name is " + name + emailId;
    }
}
