package com.yoaki.BugTracker.services.impl;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.yoaki.BugTracker.domain.Comment;
import com.yoaki.BugTracker.domain.Ticket;
import com.yoaki.BugTracker.domain.dto.CommentDTO;
import com.yoaki.BugTracker.mappers.Mapper;
import com.yoaki.BugTracker.repositories.CommentRepository;
import com.yoaki.BugTracker.repositories.TicketRepository;
import com.yoaki.BugTracker.services.CommentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final TicketRepository ticketRepository;
    private final CommentRepository commentRepository;
    private final Mapper<Comment, CommentDTO> commentMapper;


    @Override
    public CommentDTO saveComment(CommentDTO commentDTO, Long ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId).orElse(null);
        Comment comment = commentMapper.mapFrom(commentDTO);


        String timeStamp = new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss").format(new java.util.Date());
        comment.setCreatedAt(timeStamp);

        Comment saveComment = commentRepository.save(comment);
        return commentMapper.mapTo(saveComment);
    }

    @Override
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
    
}
