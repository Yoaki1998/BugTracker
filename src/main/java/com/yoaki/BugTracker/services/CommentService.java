package com.yoaki.BugTracker.services;

import java.util.List;

import com.yoaki.BugTracker.domain.dto.CommentDTO;

public interface CommentService {

    List<CommentDTO> getAllComment();
    CommentDTO getCommentById(Long id);
    CommentDTO saveComment(CommentDTO commentDTO);
    void deleteComment(Long id);
    
}
