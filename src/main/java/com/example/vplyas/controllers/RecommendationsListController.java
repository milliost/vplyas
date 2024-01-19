package com.example.vplyas.controllers;

import com.example.vplyas.entity.RecommendationsList;
import com.example.vplyas.service.RecommendationsListDTOServive;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class RecommendationsListController {

  RecommendationsListDTOServive service;

  @PostMapping("/recommendationsList")
  public UUID createRecommendationsList(@ModelAttribute RecommendationsList recList) {
    return service.createRecommendationsList(recList);
  }

  @PatchMapping("/recommendationsList/{UUID}")
  public void updateRecommendationsList(@PathVariable UUID UUID,
      @ModelAttribute RecommendationsList recList) {
    service.updateRecommendationsList(UUID, recList);
  }

  @DeleteMapping("/recommendationsList/{id}")
  public void deleteRecommendationsList(@PathVariable("id") UUID lessonUUID) {
    service.deleteRecommendationsLis(lessonUUID);
  }

  @GetMapping("/recommendationsList/{id}")
  public RecommendationsList getCourseRecommendationsList(
      @PathVariable("id") UUID id) {
    return service.getRecommendationsList(id);
  }
}
