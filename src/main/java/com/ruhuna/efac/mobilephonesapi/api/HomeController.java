package com.ruhuna.efac.mobilephonesapi.api;


import com.ruhuna.efac.mobilephonesapi.db.UserRepository;
import com.ruhuna.efac.mobilephonesapi.models.User;
import com.ruhuna.efac.mobilephonesapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    private UserRepository userRepository;
    @GetMapping("/")
    public  String home(){
        return ("<h1>Welcome to My App</h1>");
    }

    @GetMapping("/validateLogin")
    public User validateLogin(){
        return  userRepository;
    }

}
