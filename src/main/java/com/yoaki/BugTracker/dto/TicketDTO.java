package com.yoaki.BugTracker.dto;


import lombok.Data;

@Data
public class TicketDTO {
    
    private Long id;
    private String title;
    private String submitter;
    private String assignedTo;
    private String status;
    private String priority;
    private String createdAt;
    private String updatedAt;
    private Long projectId;
}
