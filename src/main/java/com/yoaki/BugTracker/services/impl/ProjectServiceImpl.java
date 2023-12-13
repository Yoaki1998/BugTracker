package com.yoaki.BugTracker.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.yoaki.BugTracker.domain.Project;
import com.yoaki.BugTracker.domain.dto.ProjectDTO;
import com.yoaki.BugTracker.mappers.Mapper;
import com.yoaki.BugTracker.repositories.ProjectRepository;
import com.yoaki.BugTracker.services.ProjectService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final Mapper<Project, ProjectDTO> projectMapper;

    @Override
    public List<ProjectDTO> getAllProject() {
        List<Project> projects = projectRepository.findAll();
        return projects.stream()
            .map(projectMapper::mapTo)
            .collect(Collectors.toList());
    }

    @Override
    public ProjectDTO getProjectById(Long id) {
        Project project = projectRepository.findById(id).orElse(null);
        return projectMapper.mapTo(project);
    }

    @Override
    public ProjectDTO saveProject(ProjectDTO projectDTO) {
        Project project = projectMapper.mapFrom(projectDTO);
        Project saveProject = projectRepository.save(project);
        return projectMapper.mapTo(saveProject);
    }

    @Override
    public void deleteProject(Long id) {
        projectRepository.deleteById(id);

    }
    
}
