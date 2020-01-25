package com.ruhuna.efac.mobilephonesapi.api;

import com.ruhuna.efac.mobilephonesapi.db.UserRepository;
import com.ruhuna.efac.mobilephonesapi.mapper.Mapper;
import com.ruhuna.efac.mobilephonesapi.viewModels.UserViewModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(value = "api/users/")
public class UserController {

    private Mapper mapper;
    private UserRepository userRepository;

    public UserController(Mapper mapper, UserRepository userRepository) {
        this.mapper = mapper;
        this.userRepository = userRepository;
    }

    @RequestMapping(value="/all" ,method = GET)
    public List<UserViewModel> getAll(){
        return userRepository.findAll()
                .stream().map(user ->
                    this.mapper.convertToUserViewModel(user)
                ).collect(Collectors.toList());
    }
}
