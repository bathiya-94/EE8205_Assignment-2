package com.ruhuna.efac.mobilephonesapi.mapper;
import com.ruhuna.efac.mobilephonesapi.db.PhoneRepository;
import com.ruhuna.efac.mobilephonesapi.db.UserRepository;
import com.ruhuna.efac.mobilephonesapi.models.Phone;
import com.ruhuna.efac.mobilephonesapi.models.User;
import com.ruhuna.efac.mobilephonesapi.viewModels.PhoneViewModel;
import com.ruhuna.efac.mobilephonesapi.viewModels.UserViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Null;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class Mapper {
    private UserRepository userRepository;
    private PhoneRepository PhoneRepository;

    public Mapper(UserRepository userRepository, PhoneRepository PhoneRepository) {
        this.userRepository = userRepository;
        this.PhoneRepository = PhoneRepository;
    }

    public PhoneViewModel convertToPhoneViewModel(Phone Phone)
    {
        PhoneViewModel PhoneViewModel = new PhoneViewModel(Phone.getId(),Phone.getModelNo(),
                                                        Phone.getModelName(),Phone.getBrand(),
                                                            Phone.getImage());
        List<UserViewModel> userViewModels = Phone.getUserList().stream()
                                            .map(user -> {
                                                UserViewModel userViewModel = new UserViewModel();
                                                userViewModel.setId(user.getId());
                                                userViewModel.setEmail(user.getEmail());
                                                userViewModel.setName(user.getName());


                                                return  userViewModel;

                                            }).collect(Collectors.toList());
        PhoneViewModel.setUsers(userViewModels);
        return  PhoneViewModel;
    }

    public UserViewModel convertToUserViewModel(User user)
    {
        UserViewModel userViewModel = new UserViewModel();
        userViewModel.setId(user.getId());
        userViewModel.setName(user.getName());
        userViewModel.setEmail(user.getEmail());

        List<PhoneViewModel> PhoneViewModels = user.getFavPhones().stream()
                                                                .map(this::convertToPhoneViewModel)
                                                                .collect(Collectors.toList());
        userViewModel.setFavPhones(PhoneViewModels);
        return  userViewModel;
    }

    public User convertToUser(UserViewModel userViewModel)
    {
        User user;

        if (userViewModel.getId() == null)
        {
            user = new User();
        }
        else {

            user = userRepository.findById(userViewModel.getId()).get();
            }

        user.setName(userViewModel.getName());
        user.setEmail(userViewModel.getEmail());

        Set<Phone> Phones = userViewModel.getFavPhones().stream()
                                        .map(PhoneViewModel ->{
                                            Phone Phone =PhoneRepository.findByModelName(
                                                    PhoneViewModel.getModelName()
                                            );

                                            Phone.getUserList().add(user);
                                            return  Phone;
                                        }).collect(Collectors.toSet());
        user.setFavPhones(Phones);
        return user;
    }

    public Phone convertToPhone(PhoneViewModel PhoneViewModel)
    {
        Phone Phone;
        if (PhoneViewModel.getId() != null)
        {
            Phone = PhoneRepository.findById(PhoneViewModel.getId()).get();
        }

        else {
            Phone = new Phone();
        }
        Phone.setId(PhoneViewModel.getId());
        Phone.setModelName(PhoneViewModel.getModelName());
        Phone.setBrand(PhoneViewModel.getBrand());
        Phone.setModelNo(PhoneViewModel.getModelNo());
        Phone.setImage(PhoneViewModel.getImage());

        return Phone;

    }

}


