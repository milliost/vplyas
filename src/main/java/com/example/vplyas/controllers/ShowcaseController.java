package com.example.vplyas.controllers;

import com.example.vplyas.entity.Showcase;
import com.example.vplyas.service.ShowcaseDTOService;
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
public class ShowcaseController {

  ShowcaseDTOService service;

  @PostMapping("/courses_recommendationsList")
  public UUID createShowcase(@ModelAttribute Showcase showcase) {
    return service.createShowcase(showcase);
  }

  @GetMapping("/courses_recommendationsList/{id}")
  public Showcase getShowcase(@PathVariable("id") UUID id) {
    return service.getShowcase(id);
  }

  @PatchMapping("/courses_recommendationsList/{id}")
  public void updateShowcase(@PathVariable UUID id, @ModelAttribute Showcase CRL) {
    service.updateShowcase(id, CRL);
  }

  @DeleteMapping("/courses_recommendationsList/{id}")
  public void deleteShowcase(@PathVariable("id") UUID id) {
    service.deleteShowcase(id);
  }


}
