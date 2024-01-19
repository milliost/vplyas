package com.example.vplyas.repository;

import com.example.vplyas.entity.RecommendationsList;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecommendationsListRepository extends JpaRepository<RecommendationsList, UUID> {
  Optional<RecommendationsList> findById(UUID id);
}
