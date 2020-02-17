package com.ruhuna.efac.mobilephonesapi.api;


import com.ruhuna.efac.mobilephonesapi.db.UserRepository;
import com.ruhuna.efac.mobilephonesapi.models.LoginResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {


    @GetMapping("/")
    public  String home(){
        return ("<h1>Welcome to My App</h1>");
    }



}
