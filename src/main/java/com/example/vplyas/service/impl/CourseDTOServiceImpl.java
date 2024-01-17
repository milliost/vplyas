package com.example.vplyas.service.impl;

import com.example.vplyas.config.errors.ResourceNotFoundException;
import com.example.vplyas.entity.Course;
import com.example.vplyas.repository.CourseRepository;
import com.example.vplyas.service.CourseDTOService;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CourseDTOServiceImpl implements CourseDTOService {

  CourseRepository courseRepository;

  @Override
  public Course getCourseInfo(UUID id) {
    return courseRepository.findById(id).orElseThrow(
        () -> new ResourceNotFoundException("Course with id " + id + " not found"));
  }

  @Override
  public UUID createCourse(Course course) {
    courseRepository.save(course);
    return course.getId();
  }

  @Override
  public void updateCourse(UUID id, Course updatedCourse) {
    Course courseToBeUpdated = getCourseInfo(id);

    courseToBeUpdated.setTeacherId(updatedCourse.getTeacherId());
    courseToBeUpdated.setStatus(updatedCourse.getStatus());
    courseToBeUpdated.setTitle(updatedCourse.getTitle());
    courseToBeUpdated.setDescription(updatedCourse.getDescription());
    courseToBeUpdated.setStyle(updatedCourse.getStyle());

    //возможно удаление следующих двух методов т.к. поля должны заполняться автоматически
    courseToBeUpdated.setLessonsNumber(updatedCourse.getLessonsNumber());
    courseToBeUpdated.setAverageLessonsDuration(updatedCourse.getAverageLessonsDuration());

    courseToBeUpdated.setCoverImageUrl(updatedCourse.getCoverImageUrl());
    courseToBeUpdated.setPreviewVideoUrl(updatedCourse.getPreviewVideoUrl());
    courseToBeUpdated.setPrice(updatedCourse.getPrice());
    courseRepository.save(courseToBeUpdated);
  }

  @Override
  public void deleteCourse(UUID uuid) {
    courseRepository.delete(getCourseInfo(uuid));
  }

  @Override
  public List<Course> getCourseCatalog() {
    return courseRepository.findAll();
  }
}
