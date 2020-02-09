package com.ruhuna.efac.mobilephonesapi.db;

import com.ruhuna.efac.mobilephonesapi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository  extends JpaRepository<User,Long> {

    Optional<User> findByEmail(String email);

}
