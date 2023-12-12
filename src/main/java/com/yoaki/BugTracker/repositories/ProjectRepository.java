package com.yoaki.BugTracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yoaki.BugTracker.domain.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    
}
