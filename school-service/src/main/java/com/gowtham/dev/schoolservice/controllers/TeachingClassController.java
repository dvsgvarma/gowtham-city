package com.gowtham.dev.schoolservice.controllers;


import com.gowtham.dev.schoolservice.dtos.TeachingClassDto;
import com.gowtham.dev.schoolservice.services.TeachingClassService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/class")
public class TeachingClassController {


    private final TeachingClassService teachingClassService;

    public TeachingClassController(TeachingClassService teachingClassService) {
        this.teachingClassService = teachingClassService;
    }

    @GetMapping
    public List<TeachingClassDto> listClasses(){
        return teachingClassService.listClasses();
    }

}
