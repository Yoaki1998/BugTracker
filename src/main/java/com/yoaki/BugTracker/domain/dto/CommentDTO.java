package com.yoaki.BugTracker.domain.dto;


import lombok.Data;

@Data
public class CommentDTO {

    private Long id;
    private String message;
    private String createdAt;
    private String commenter;
}
