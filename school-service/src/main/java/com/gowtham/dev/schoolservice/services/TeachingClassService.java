package com.gowtham.dev.schoolservice.services;

import com.gowtham.dev.schoolservice.dtos.TeachingClassDto;

import java.util.List;

public interface TeachingClassService {

    List<TeachingClassDto> listClasses();
}
