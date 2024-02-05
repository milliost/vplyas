package com.example.vplyas.service;

import com.example.vplyas.entity.Showcase;
import java.util.UUID;

public interface ShowcaseDTOService {
  UUID createShowcase(Showcase Showcase);

  Showcase getShowcase(UUID id);

  void updateShowcase(UUID id, Showcase recommendationsList);

  void deleteShowcase(UUID uuid);
}
