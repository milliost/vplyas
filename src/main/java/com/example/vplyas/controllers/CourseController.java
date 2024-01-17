package com.example.vplyas.controllers;

import com.example.vplyas.entity.Course;
import com.example.vplyas.service.CourseDTOService;
import java.util.List;
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
public class CourseController {

  CourseDTOService courseDTOService;

  @PostMapping("/course")
  public UUID createCourse(@ModelAttribute Course course) {
    return courseDTOService.createCourse(course);
  }

  @GetMapping("/course/{uuid}")
  public Course getCourseInfo(@PathVariable("uuid") UUID uuid) {
    return courseDTOService.getCourseInfo(uuid);
  }

  @GetMapping("/courses")
  public List<Course> getCourseCatalog() {
    return courseDTOService.getCourseCatalog();
  }

  @PatchMapping("/course/{id}")
  public void updateCourse(@PathVariable UUID id, @ModelAttribute Course course) {
    courseDTOService.updateCourse(id, course);
  }

  @DeleteMapping("/course/{uuid}")
  public void deleteCourse(@PathVariable("uuid") UUID uuid) {
    courseDTOService.deleteCourse(uuid);
  }

}
