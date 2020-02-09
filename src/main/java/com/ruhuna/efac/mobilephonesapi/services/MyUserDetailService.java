package com.ruhuna.efac.mobilephonesapi.services;

import com.ruhuna.efac.mobilephonesapi.db.UserRepository;
import com.ruhuna.efac.mobilephonesapi.models.MyUserDetails;
import com.ruhuna.efac.mobilephonesapi.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailService  implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(email);

        user.orElseThrow(()-> new UsernameNotFoundException("Not found :"));

        return user.map(MyUserDetails::new).get();
    }
}
