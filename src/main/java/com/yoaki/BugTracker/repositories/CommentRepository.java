package com.yoaki.BugTracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yoaki.BugTracker.domain.Comment;


public interface CommentRepository extends JpaRepository<Comment, Long> {

    
}
