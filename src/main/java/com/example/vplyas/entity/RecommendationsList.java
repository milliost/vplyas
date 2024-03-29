package com.example.vplyas.entity;

import com.example.vplyas.enums.Status;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.net.URL;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "recommendations_lists")
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class RecommendationsList {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(nullable = false, unique = true)
  private String title;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private Status status;

  @Column(unique = true)
  private String description;

  @Column(unique = true)//почему оно уникальное ?
  private int coursesCount;


  @Column(unique = true)
  private URL coverImage;
}
