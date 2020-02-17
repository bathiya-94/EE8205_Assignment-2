package com.ruhuna.efac.mobilephonesapi.api;


import com.ruhuna.efac.mobilephonesapi.services.UserService;
import com.ruhuna.efac.mobilephonesapi.viewModels.UserViewModel;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

;
import javax.xml.bind.ValidationException;
import java.util.List;


import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;


@RestController
@RequestMapping(value = "/user")
@CrossOrigin
public class UserController {


    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value="/all" ,method = GET)
    public List<UserViewModel> getAll(){
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/{id}", method = GET)
    public UserViewModel getById(@PathVariable Long id)
    {
        return  userService.geUserById(id);
    }

    @RequestMapping(value ="/save", method =  POST)
    public UserViewModel save(@RequestBody UserViewModel userViewModel, BindingResult bindingResult) throws ValidationException
    {
        if (bindingResult.hasErrors())
        {
            throw  new ValidationException("User");
        }
        return  userService.saveUser(userViewModel);
    }

    @DeleteMapping("{/id}")
    public  void delete(@PathVariable Long id)
    {

        this.userService.deleteUser(id);
    }
}
