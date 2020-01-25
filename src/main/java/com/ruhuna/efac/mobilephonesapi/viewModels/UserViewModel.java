package com.ruhuna.efac.mobilephonesapi.viewModels;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class UserViewModel {
    private  Long id;

    @NotNull
    private  String name;

    @Email
    private  String email;

    private List<PhoneViewModel> favPhones;

    public  UserViewModel()
    {
        this.favPhones = new ArrayList<>();
    }

    public UserViewModel(Long id, @NotNull String name, @Email String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<PhoneViewModel> getFavPhones() {
        return favPhones;
    }

    public void setFavPhones(List<PhoneViewModel> favPhones) {
        this.favPhones = favPhones;
    }
}
