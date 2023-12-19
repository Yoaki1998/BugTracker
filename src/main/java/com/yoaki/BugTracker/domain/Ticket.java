package com.yoaki.BugTracker.domain;

import java.util.List;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Ticket {
    
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;
    private String title;
    private String status;
    private String type;
    private String priority;
    private String createdAt;
    private String updatedAt;

    @OneToMany(mappedBy = "ticket" ,cascade = CascadeType.ALL)
    private List<Comment> comments;


    private Long project;

    private String submitter;

    private String assignedTo;


}
