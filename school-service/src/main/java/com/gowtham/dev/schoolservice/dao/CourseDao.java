package com.gowtham.dev.schoolservice.dao;

import com.gowtham.dev.schoolservice.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseDao extends JpaRepository<Course, Long> {
}
