package com.ruhuna.efac.mobilephonesapi.services;

import com.ruhuna.efac.mobilephonesapi.db.PhoneRepository;
import com.ruhuna.efac.mobilephonesapi.mapper.Mapper;
import com.ruhuna.efac.mobilephonesapi.viewModels.PhoneViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PhoneService {

    @Autowired
    private PhoneRepository phoneRepository;

    @Autowired
    private Mapper mapper;

    public List<PhoneViewModel> getAllPhones(){
        return phoneRepository.findAll()
                .stream().map(phone ->
                        this.mapper.convertToPhoneViewModel(phone)
                ).collect(Collectors.toList());
    }

    public List<PhoneViewModel> getByBrand(String brand){
        return phoneRepository.findByBrand(brand)
                .stream().map(phone ->
                        this.mapper.convertToPhoneViewModel(phone)
                ).collect(Collectors.toList());
    }




}
