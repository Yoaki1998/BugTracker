package com.yoaki.BugTracker.domain;

import java.util.List;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Project {
    
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<Ticket> tickets;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "manager_id")
    private Utilisateur manager;
}
