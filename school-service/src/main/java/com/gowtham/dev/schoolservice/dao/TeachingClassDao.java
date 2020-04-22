package com.gowtham.dev.schoolservice.dao;

import com.gowtham.dev.schoolservice.entities.TeachingClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeachingClassDao extends JpaRepository<TeachingClass, Long> {}
