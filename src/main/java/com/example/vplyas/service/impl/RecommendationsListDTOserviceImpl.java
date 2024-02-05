package com.example.vplyas.service.impl;

import com.example.vplyas.config.errors.ResourceNotFoundException;
import com.example.vplyas.entity.RecommendationsList;
import com.example.vplyas.repository.RecommendationsListRepository;
import com.example.vplyas.service.RecommendationsListDTOServive;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class RecommendationsListDTOserviceImpl implements RecommendationsListDTOServive {

  RecommendationsListRepository recommendationsListRepository;

  @Override
  public UUID createRecommendationsList(RecommendationsList recList) {
    recommendationsListRepository.save(recList);
    return recList.getId();
  }

  @Override
  public RecommendationsList getRecommendationsList(UUID id) {
    return recommendationsListRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException(
            "Recommendation list with id " + id + " not found"));
  }

  @Override
  public void updateRecommendationsList(UUID id, RecommendationsList updatedRecList) {
    RecommendationsList recListToBeUpdated = getRecommendationsList(id);
    recListToBeUpdated.setTitle(updatedRecList.getTitle());
    recListToBeUpdated.setDescription(updatedRecList.getDescription());
    recListToBeUpdated.setStatus(updatedRecList.getStatus());
    recListToBeUpdated.setCoursesCount(updatedRecList.getCoursesCount());
    recListToBeUpdated.setCoverImage(updatedRecList.getCoverImage());
    recommendationsListRepository.save(recListToBeUpdated);
  }

  @Override
  public void deleteRecommendationsList(UUID id) {
    recommendationsListRepository.deleteById(id);
  }
}
