package com.ruhuna.efac.mobilephonesapi.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private  Long id;
    private  String modelNo;
    private  String modelName;
    private  String brand;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    private  String image;

    @ManyToMany(mappedBy = "favPhones")
    private Set<User> userList = new HashSet<>();

    public Phone(){};

    public Phone( String modelNo, String modelName, String brand, String image)
    {
        this.modelNo = modelNo;
        this.modelName = modelName;
        this.brand = brand;
        this.image = image;
    }

    public Set<User> getUserList()
    {
        return userList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserList(Set<User> userList)
    {
        this.userList = userList;
    }

    public String getModelNo()
    {
        return modelNo;
    }

    public void setModelNo(String modelNo)
    {
        this.modelNo = modelNo;
    }

    public String getModelName()
    {
        return modelName;
    }

    public void setModelName(String modelName)
    {
        this.modelName = modelName;
    }

    public String getBrand()
    {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
