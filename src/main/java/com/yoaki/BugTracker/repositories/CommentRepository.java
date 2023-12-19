package com.yoaki.BugTracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yoaki.BugTracker.domain.Comment;
import com.yoaki.BugTracker.domain.Ticket;

import java.util.List;


public interface CommentRepository extends JpaRepository<Comment, Long> {

    
}
