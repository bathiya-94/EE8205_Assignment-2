package com.ruhuna.efac.mobilephonesapi.services;

import com.ruhuna.efac.mobilephonesapi.db.UserRepository;
import com.ruhuna.efac.mobilephonesapi.mapper.Mapper;
import com.ruhuna.efac.mobilephonesapi.models.User;
import com.ruhuna.efac.mobilephonesapi.viewModels.UserViewModel;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.EntityNotFoundException;
import javax.xml.bind.ValidationException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private UserRepository userRepository;
    private Mapper mapper;

    public UserService(UserRepository userRepository, Mapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    public List<UserViewModel> getAllUsers(){
            return userRepository.findAll()
                    .stream().map(user ->
                            this.mapper.convertToUserViewModel(user)
                    ).collect(Collectors.toList());
    }

    public UserViewModel geUserById(Long id)
    {
        User user = userRepository.findById(id).orElse(null);

        if (user == null)
        {
            throw  new EntityNotFoundException();
        }
        return  this.mapper.convertToUserViewModel(user);
    }

    public UserViewModel saveUser( UserViewModel userViewModel)
    {
        User user  = this.mapper.convertToUser(userViewModel);
        this.userRepository.save(user);

        return  this.mapper.convertToUserViewModel(user);
    }

    public  void deleteUser(Long id)
    {
        this.userRepository.deleteById(id);
    }

}
