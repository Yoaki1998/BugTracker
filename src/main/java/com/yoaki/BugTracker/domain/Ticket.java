package com.yoaki.BugTracker.domain;

import java.util.List;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "submitter_id")
    private Utilisateur submitter;

    @ManyToOne
    @JoinColumn(name = "assignedTo_id")
    private Utilisateur assignedTo;

    @Cascade(CascadeType.ALL)
    @OneToMany(mappedBy = "ticket")
    private List<Comment> comments;
}
