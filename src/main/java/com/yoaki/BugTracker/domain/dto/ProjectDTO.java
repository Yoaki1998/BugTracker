package com.yoaki.BugTracker.domain.dto;



import lombok.Data;

@Data
public class ProjectDTO {

    private Long id;
    private String name;
    private String description;

    private UtilisateurDTO manager;

}
