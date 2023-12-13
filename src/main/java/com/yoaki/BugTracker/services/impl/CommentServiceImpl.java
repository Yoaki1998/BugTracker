package com.yoaki.BugTracker.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.yoaki.BugTracker.domain.Comment;
import com.yoaki.BugTracker.domain.dto.CommentDTO;
import com.yoaki.BugTracker.mappers.Mapper;
import com.yoaki.BugTracker.repositories.CommentRepository;
import com.yoaki.BugTracker.services.CommentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final Mapper<Comment, CommentDTO> commentMapper;

    @Override
    public List<CommentDTO> getAllComment() {
        List<Comment> comments = commentRepository.findAll();
        return comments.stream()
            .map(commentMapper::mapTo)
            .collect(Collectors.toList());
    }

    @Override
    public CommentDTO getCommentById(Long id) {
        Comment comment = commentRepository.findById(id).orElse(null);
        return commentMapper.mapTo(comment);
    }

    @Override
    public CommentDTO saveComment(CommentDTO commentDTO) {
        Comment comment = commentMapper.mapFrom(commentDTO);
        Comment saveComment = commentRepository.save(comment);
        return commentMapper.mapTo(saveComment);
    }

    @Override
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
    
}
