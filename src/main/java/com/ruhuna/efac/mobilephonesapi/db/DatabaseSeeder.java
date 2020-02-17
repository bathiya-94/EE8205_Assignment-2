package com.ruhuna.efac.mobilephonesapi.db;

import com.ruhuna.efac.mobilephonesapi.models.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseSeeder implements CommandLineRunner {
    private  PhoneRepository phoneRepository;

    @Autowired
    public DatabaseSeeder(PhoneRepository phoneRepository){
        this.phoneRepository = phoneRepository;
    }

    @Override
    public  void  run(String... strings) throws Exception{
        List<Phone> phones = new ArrayList<>();
        phones.add(new Phone("SM5000","S11","Samsung",
                "https://www.ideabeam.com/images/product/big/samsung-galaxy-s10-plus.jpg"));
        phones.add(new Phone("i97067","i11 Pro Max","iphone",
                "https://www.ideabeam.com/images/product/big/apple-iphone-11-pro-max.jpg"));
        phones.add(new Phone("G7067","Pixel 4","Google",
                "https://www.ideabeam.com/images/product/big/google-pixel-4-xl.jpg"));
        phones.add(new Phone("S5062","iphone 11","iphone",
                "https://fdn2.gsmarena.com/vv/bigpic/apple-iphone-11.jpg"));
        phones.add(new Phone("A3495","7T","OnePlus",
                "https://www.ideabeam.com/images/product/big/oneplus-7t.jpg"));
        phoneRepository.saveAll(phones);
    }
}