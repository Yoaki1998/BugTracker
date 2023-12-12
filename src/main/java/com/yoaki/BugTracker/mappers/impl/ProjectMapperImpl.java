package com.yoaki.BugTracker.mappers.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.yoaki.BugTracker.domain.Project;
import com.yoaki.BugTracker.domain.dto.ProjectDTO;
import com.yoaki.BugTracker.mappers.Mapper;

@Component
public class ProjectMapperImpl implements Mapper<Project, ProjectDTO> {

    private ModelMapper modelMapper;

    public ProjectMapperImpl (ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public ProjectDTO mapTo(Project project) {
        return modelMapper.map(project, ProjectDTO.class);
    }

    @Override
    public Project mapFrom(ProjectDTO projectDTO) {
        return modelMapper.map(projectDTO, Project.class);
    }


    
}
