package com.yoaki.BugTracker.controllers;

import com.yoaki.BugTracker.services.ProjectService;
import com.yoaki.BugTracker.services.UtilisateurService;

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
    private final UtilisateurService utilisateurService;

    @GetMapping
    public List<ProjectDTO> getAllProject() {
        return projectService.getAllProject();
    }
    
    
    @GetMapping("/{id}")
    public ProjectDTO getProjectById(@PathVariable Long id) {
        return projectService.getProjectById(id);
    }

    @PostMapping
    public ProjectDTO saveProject(@RequestBody ProjectDTO projectDTO) {
        return projectService.saveProject(projectDTO);
    }

    @PutMapping("/{id}")
    public ProjectDTO updateProject(@PathVariable Long id, @RequestBody ProjectDTO projectDTO) {
        return projectService.updateProject(id, projectDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
        return ResponseEntity.ok().build();
    }
    
    
}
