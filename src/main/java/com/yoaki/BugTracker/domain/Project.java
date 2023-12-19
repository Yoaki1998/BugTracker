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
    private String manager;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "tickets")
    private List<Ticket> tickets;
}
