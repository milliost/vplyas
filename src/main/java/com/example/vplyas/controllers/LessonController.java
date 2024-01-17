package com.example.vplyas.controllers;

import com.example.vplyas.entity.Lesson;
import com.example.vplyas.service.LessonDTOService;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@AllArgsConstructor
@RestController
public class LessonController {

  private static final Logger logger = LoggerFactory.getLogger(LessonController.class);
  LessonDTOService lessonDTOService;

  @PostMapping("/course/{courseUUID}/lesson")
  public UUID createLesson(@PathVariable("courseUUID") UUID courseUUID,
      @ModelAttribute Lesson lesson) {
    logger.info(lesson.getVideo_url().toString());
    return lessonDTOService.createLesson(courseUUID, lesson);
  }

  @PatchMapping("/course/lesson/{lessonUUID}")
  public void updateLesson(@PathVariable UUID lessonUUID, @ModelAttribute Lesson lesson) {
    lessonDTOService.updateLesson(lessonUUID, lesson);
  }

  @DeleteMapping("/course/lesson/{lessonUUID}")
  public void deleteCourse(@PathVariable("lessonUUID") UUID lessonUUID) {
    lessonDTOService.deleteLesson(lessonUUID);
  }

  @GetMapping("/lessons/{course_id}")
  public List<Lesson> getCourseLessons(@PathVariable("course_id") UUID course_id) {
    return lessonDTOService.getCourseLessons(course_id);
  }
}
