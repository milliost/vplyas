package com.example.vplyas.repository;

import com.example.vplyas.entity.User;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, UUID> {

  User findByName(String name);
}
