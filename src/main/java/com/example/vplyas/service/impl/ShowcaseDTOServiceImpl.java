package com.example.vplyas.service.impl;

import com.example.vplyas.config.errors.ResourceNotFoundException;
import com.example.vplyas.entity.Showcase;
import com.example.vplyas.repository.ShowcaseRepository;
import com.example.vplyas.service.ShowcaseDTOService;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ShowcaseDTOServiceImpl implements ShowcaseDTOService {

  ShowcaseRepository repository;

  @Override
  public UUID createShowcase(Showcase showcase) {
    repository.save(showcase);
    return showcase.getId();
  }

  @Override
  public Showcase getShowcase(UUID id) {
    return repository.findById(id).orElseThrow(
        () -> new ResourceNotFoundException(
            "CoursesRecommendationsLists with id " + id + " not found"));
  }

  @Override
  public void updateShowcase(UUID id,
      Showcase updated) {
    Showcase ToBeUpdated = getShowcase(id);

    ToBeUpdated.setCourse(updated.getCourse());
    ToBeUpdated.setRecommendationsList(updated.getRecommendationsList());
    repository.save(ToBeUpdated);
  }

  @Override
  public void deleteShowcase(UUID uuid) {
    repository.deleteById(uuid);
  }
}
