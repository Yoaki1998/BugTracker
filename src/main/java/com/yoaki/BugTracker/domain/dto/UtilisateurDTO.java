package com.yoaki.BugTracker.domain.dto;

import java.util.List;

import lombok.Data;

@Data
public class UtilisateurDTO {
    
    private String id;
    private String name;
    private String picture;
    private String locale;
    private String email;
    private Boolean email_verified;
    private String iss;
    private List<String> submittedTickets;
    private List<String> assignedTickets;
    
}
