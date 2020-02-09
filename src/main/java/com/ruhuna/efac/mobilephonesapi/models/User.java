package com.ruhuna.efac.mobilephonesapi.models;

import javax.persistence.*;


import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private  long id;
    private  String name;
    private  String email;
    private  String password;
    private  String roles;

    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,
            CascadeType.MERGE})
    @JoinTable(name = "Users_Phone",
            joinColumns = {
                    @JoinColumn(
                            name = "users_id",
                            referencedColumnName = "id"
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "phone_id",
                            referencedColumnName = "id"
                    )
            })
    private Set<Phone> favPhones;

    public User() {
    }

    public  User (String name, String email, String password, String role)
    {
        this.name = name;
        this.email = email;
        this.password = password;
        this.roles = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Phone> getFavPhones() {
        return favPhones;
    }

    public void setFavPhones(Set<Phone> favPhones) {
        this.favPhones = favPhones;
    }
}
