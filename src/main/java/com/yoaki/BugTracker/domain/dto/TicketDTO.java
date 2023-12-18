package com.yoaki.BugTracker.domain.dto;


import lombok.Data;

@Data
public class TicketDTO {
    
    private Long id;
    private String title;
    private String status;
    private String type;
    private String priority;
    private String createdAt;
    private String updatedAt;
    
    private ProjectDTO project;

    private UtilisateurDTO submitter;

    private UtilisateurDTO assignedTo;
}
