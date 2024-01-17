package com.example.vplyas.repository;

import com.example.vplyas.entity.Lesson;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, UUID> {

  @NonNull
  Optional<Lesson> findById(@NonNull UUID id);

  List<Lesson> findAllByCourseId(UUID id);
}

