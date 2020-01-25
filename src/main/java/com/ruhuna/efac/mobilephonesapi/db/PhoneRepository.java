package com.ruhuna.efac.mobilephonesapi.db;

import com.ruhuna.efac.mobilephonesapi.models.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone,Long> {
    Phone findByModelName(String modelName);
}
