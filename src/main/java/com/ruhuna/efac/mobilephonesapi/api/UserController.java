package com.ruhuna.efac.mobilephonesapi.api;

import com.ruhuna.efac.mobilephonesapi.db.UserRepository;
import com.ruhuna.efac.mobilephonesapi.mapper.Mapper;
import com.ruhuna.efac.mobilephonesapi.models.User;
import com.ruhuna.efac.mobilephonesapi.viewModels.UserViewModel;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.xml.bind.ValidationException;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

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

    @RequestMapping(value = "/{id}", method = GET)
    public UserViewModel getById(@PathVariable Long id)
    {
        User user = userRepository.findById(id).orElse(null);

        if (user == null)
        {
            throw  new EntityNotFoundException();
        }
        return  this.mapper.convertToUserViewModel(user);
    }

    @RequestMapping(value ="/save", method =  POST)
    public UserViewModel save(@RequestBody UserViewModel userViewModel, BindingResult bindingResult) throws ValidationException
    {
        if (bindingResult.hasErrors())
        {
            throw  new ValidationException("User");
        }

        System.out.println(userViewModel.getId());

        User user  = this.mapper.convertToUser(userViewModel);
        this.userRepository.save(user);

        return  this.mapper.convertToUserViewModel(user);
    }

    @DeleteMapping("{/id}")
    public  void delete(@PathVariable Long id)
    {
        this.userRepository.deleteById(id);
    }
}
