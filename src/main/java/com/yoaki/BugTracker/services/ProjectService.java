package com.yoaki.BugTracker.services;

import java.util.List;

import com.yoaki.BugTracker.domain.dto.ProjectDTO;


public interface ProjectService {

    List<ProjectDTO> getAllProject();
    ProjectDTO getProjectById(Long id);
    ProjectDTO saveProject(ProjectDTO projectDTO);
    ProjectDTO updateProject(Long id, ProjectDTO projectDTO);
    void deleteProject(Long id);
    
}
