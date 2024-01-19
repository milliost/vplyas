package com.example.vplyas.service;

import com.example.vplyas.entity.RecommendationsList;
import java.util.UUID;

public interface RecommendationsListDTOServive {

  UUID createRecommendationsList(RecommendationsList recommendationsList);

  RecommendationsList getRecommendationsList(UUID RecommendationsListId);

  void updateRecommendationsList(UUID id, RecommendationsList recommendationsList);

  void deleteRecommendationsLis(UUID uuid);

}
