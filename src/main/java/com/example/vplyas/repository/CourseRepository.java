package com.example.vplyas.repository;

import com.example.vplyas.entity.Course;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, UUID> {

  Optional<Course> findById(UUID id);
}
