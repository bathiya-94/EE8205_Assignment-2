//package com.ruhuna.efac.mobilephonesapi.db;
//
//import com.ruhuna.efac.mobilephonesapi.models.Phone;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class DatabaseSeeder implements CommandLineRunner {
//    private  PhoneRepository skillRepository;
//
//    @Autowired
//    public DatabaseSeeder(PhoneRepository skillRepository){
//        this.skillRepository = skillRepository;
//    }
//
//    @Override
//    public  void  run(String... strings) throws Exception{
//        List<Phone> phones = new ArrayList<>();
//        phones.add(new Phone("SM5000","S5","Samsung"));
//        phones.add(new Phone("i97067","i11","iphone"));
//        phones.add(new Phone("G7067","Pixel 3a","Google"));
//        phones.add(new Phone("S5062","S9","Samsung"));
//        phones.add(new Phone("A3495","7T","OnePlus"));
//        skillRepository.saveAll(phones);
//    }
//}