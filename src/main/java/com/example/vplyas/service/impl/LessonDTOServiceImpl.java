package com.example.vplyas.service.impl;

import com.example.vplyas.config.errors.ResourceNotFoundException;
import com.example.vplyas.entity.Lesson;
import com.example.vplyas.repository.LessonRepository;
import com.example.vplyas.service.CourseDTOService;
import com.example.vplyas.service.LessonDTOService;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class LessonDTOServiceImpl implements LessonDTOService {

  LessonRepository lessonRepository;
  CourseDTOService courseDTOService;

  @Override
  public UUID createLesson(UUID courseUUID, Lesson lesson) {
    lesson.setCourse(courseDTOService.getCourseInfo(courseUUID));
    lessonRepository.save(lesson);
    return lesson.getId();
  }

  @Override
  public void updateLesson(UUID uuid, Lesson updatedLesson) {
    Lesson lessonToBeUpdated = getLessonByUUID(uuid);
    lessonToBeUpdated.setTitle(updatedLesson.getTitle());
    lessonToBeUpdated.setDescription(updatedLesson.getDescription());
    lessonToBeUpdated.setDuration(updatedLesson.getDuration());
    lessonToBeUpdated.setOrder(updatedLesson.getOrder());
    lessonToBeUpdated.setVideo_url(updatedLesson.getVideo_url());
    lessonRepository.save(lessonToBeUpdated);
  }

  @Override
  public void deleteLesson(UUID uuid) {
    lessonRepository.delete(getLessonByUUID(uuid));
  }

  @Override
  public List<Lesson> getCourseLessons(UUID courseId) {
    return lessonRepository.findAllByCourseId(courseId)
        .stream()
        .sorted(Comparator.comparingInt(Lesson::getOrder))
        .toList();
  }

  public Lesson getLessonByUUID(UUID lessonUUID) {
    return lessonRepository.findById(lessonUUID).orElseThrow(
        () -> new ResourceNotFoundException("Lesson with id " + lessonUUID + " not found"));
  }
}
