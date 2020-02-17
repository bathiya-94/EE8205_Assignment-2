package com.ruhuna.efac.mobilephonesapi.api;


import com.ruhuna.efac.mobilephonesapi.services.PhoneService;
import com.ruhuna.efac.mobilephonesapi.viewModels.PhoneViewModel;

import com.ruhuna.efac.mobilephonesapi.viewModels.UserViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(value = "/phone")
@CrossOrigin
public class PhoneController {

    @Autowired
    private PhoneService phoneService;

    @RequestMapping(value="/all" ,method = GET)
    public List<PhoneViewModel> getAll(){
        return phoneService.getAllPhones();
    }

    @RequestMapping(value = "/{brand}", method = GET)
    public List<PhoneViewModel> getById(@PathVariable String brand)
    {
        return  phoneService.getByBrand(brand);
    }

//    @RequestMapping(value="/addPhone", method=POST)
//    public l




}
