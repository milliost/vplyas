package com.example.vplyas.entity;

import com.example.vplyas.enums.Status;
import com.example.vplyas.enums.Style;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "courses")
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Course {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @ManyToOne
  @JoinColumn
  private User teacherId;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private Status status;

  @Column(nullable = false, unique = true)
  private String title;

  @Enumerated(EnumType.STRING)
  private Style style;

  @Column(nullable = false)
  private int lessonsNumber;

  @Column(nullable = false)
  private int averageLessonsDuration;

  private Date createdAt;
  private String description;
  private String coverImageUrl;
  private String previewVideoUrl;
  private BigDecimal price;
}
