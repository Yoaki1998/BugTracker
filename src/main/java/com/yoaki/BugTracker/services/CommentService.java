package com.yoaki.BugTracker.services;

import java.util.List;

import com.yoaki.BugTracker.domain.dto.CommentDTO;

public interface CommentService {

    List<CommentDTO> getAllComment(Long ticketId);
    CommentDTO saveComment(CommentDTO commentDTO, Long ticketId);
    //Ununsed
    void deleteComment(Long id);
    
}
