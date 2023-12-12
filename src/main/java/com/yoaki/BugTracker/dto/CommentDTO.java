package com.yoaki.BugTracker.dto;


import lombok.Data;

@Data
public class CommentDTO {

    private Long id;
    private String commenter;
    private String message;
    private String createdAt;
    private Long ticketId;
    
}
