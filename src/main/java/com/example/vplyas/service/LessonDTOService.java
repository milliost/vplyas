package com.example.vplyas.service;

import com.example.vplyas.entity.Lesson;
import java.util.List;
import java.util.UUID;

public interface LessonDTOService {

  UUID createLesson(UUID courseUUID, Lesson lesson);

  void updateLesson(UUID id, Lesson updatedLesson);

  void deleteLesson(UUID uuid);

  List<Lesson> getCourseLessons(UUID courseId);

}
