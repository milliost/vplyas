package com.example.vplyas.repository;

import com.example.vplyas.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

  Role findByName(String roleName);
}
