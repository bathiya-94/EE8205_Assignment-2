package com.ruhuna.efac.mobilephonesapi.viewModels;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class PhoneViewModel {
    private  Long id;

    @NotNull
    private  String modelNo;

    @NotNull
    private  String modelName;

    @NotNull
    private  String brand;

    private  String image;

    private List<UserViewModel> users;

    public PhoneViewModel()
    {
        this.users = new ArrayList<>();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public PhoneViewModel(Long id, @NotNull String modelNo, @NotNull String modelName, @NotNull String brand, String image) {
        this();
        this.id = id;
        this.modelNo = modelNo;
        this.modelName = modelName;
        this.brand = brand;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelNo() {
        return modelNo;
    }

    public void setModelNo(String modelNo) {
        this.modelNo = modelNo;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public List<UserViewModel> getUsers() {
        return users;
    }

    public void setUsers(List<UserViewModel> users) {
        this.users = users;
    }
}
