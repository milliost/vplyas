package com.example.vplyas.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "showcase")
public class Showcase {

  @ManyToOne
  @JoinColumn(name = "recommendations_lists_id")
  RecommendationsList recommendationsList;

  @ManyToOne
  @JoinColumn(name = "course_id")
  Course course;

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;


}
