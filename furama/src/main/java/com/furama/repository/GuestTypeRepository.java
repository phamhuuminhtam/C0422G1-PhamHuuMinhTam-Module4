package com.furama.repository;

import com.furama.model.GuestType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestTypeRepository extends JpaRepository<GuestType, Integer> {
}
