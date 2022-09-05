package com.phone.repository;

import com.phone.model.SmartPhone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SmartPhoneRepository extends JpaRepository<SmartPhone, Long> {
}
