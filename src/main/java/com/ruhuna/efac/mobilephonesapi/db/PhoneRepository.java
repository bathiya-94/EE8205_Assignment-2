package com.ruhuna.efac.mobilephonesapi.db;

import com.ruhuna.efac.mobilephonesapi.models.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhoneRepository extends JpaRepository<Phone,Long> {
    Phone findByModelName(String modelName);
    List<Phone> findByBrand(String brand);
    List<Phone> getByModelName(String modelName);

}
