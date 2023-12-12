package com.yoaki.BugTracker.mappers.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.yoaki.BugTracker.domain.Comment;
import com.yoaki.BugTracker.domain.dto.CommentDTO;
import com.yoaki.BugTracker.mappers.Mapper;

@Component
public class CommentMapperImpl implements Mapper<Comment, CommentDTO> {

    private ModelMapper modelMapper;

    public CommentMapperImpl (ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public CommentDTO mapTo(Comment comment) {
        return modelMapper.map(comment, CommentDTO.class);
    }

    @Override
    public Comment mapFrom(CommentDTO commentDTO) {
        return modelMapper.map(commentDTO, Comment.class);
    }
    
}
