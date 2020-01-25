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

    public  User (){};

    public User(long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
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
