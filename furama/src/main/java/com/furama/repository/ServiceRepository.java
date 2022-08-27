package com.furama.repository;

import com.furama.model.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<ServiceType, Integer> {
}
