package com.ruhuna.efac.mobilephonesapi.db;

import com.ruhuna.efac.mobilephonesapi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User,Long> {

}
