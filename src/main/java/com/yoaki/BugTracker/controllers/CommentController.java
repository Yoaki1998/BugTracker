package com.yoaki.BugTracker.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.yoaki.BugTracker.domain.dto.CommentDTO;
import com.yoaki.BugTracker.services.CommentService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequiredArgsConstructor
public class CommentController {
    
    private final CommentService commentService;



    @PostMapping("api/tickets/{ticketId}/comments")
    public CommentDTO saveComment(@RequestBody CommentDTO commentDTO, @PathVariable Long ticketId) {
        return commentService.saveComment(commentDTO, ticketId);
    }

}
