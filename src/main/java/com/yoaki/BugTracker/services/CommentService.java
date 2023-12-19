package com.yoaki.BugTracker.services;


import com.yoaki.BugTracker.domain.dto.CommentDTO;

public interface CommentService {

    CommentDTO saveComment(CommentDTO commentDTO, Long ticketId);
    //Ununsed
    void deleteComment(Long id);
    
}
