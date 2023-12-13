package com.yoaki.BugTracker.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.yoaki.BugTracker.services.ProjectService;

import lombok.RequiredArgsConstructor;

import com.yoaki.BugTracker.domain.dto.ProjectDTO;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequiredArgsConstructor
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping
    public List<ProjectDTO> getAllProject() {
        return projectService.getAllProject();
    }
    
    
    @GetMapping("/id")
    public ProjectDTO getProjectById(@PathVariable Long id) {
        return projectService.getProjectById(id);
    }

    @PostMapping
    public ProjectDTO saveProjec(@RequestBody ProjectDTO projectDTO) {
        return projectService.saveProject(projectDTO);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
        return ResponseEntity.ok().build();
    }
    
    
}
