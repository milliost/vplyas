package com.example.vplyas.repository;

import com.example.vplyas.entity.Lesson;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, UUID> {

  Optional<Lesson> findById(UUID id);

  List<Lesson> findAllByCourseId(UUID id);
}

