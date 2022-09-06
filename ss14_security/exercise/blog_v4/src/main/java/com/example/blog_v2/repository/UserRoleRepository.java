package com.example.blog_v2.repository;

import com.example.blog_v2.model.AppUser;
import com.example.blog_v2.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    List<UserRole> findByAppUser(AppUser appUser);
}
