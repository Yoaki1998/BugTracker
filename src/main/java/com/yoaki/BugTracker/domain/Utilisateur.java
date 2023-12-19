package com.yoaki.BugTracker.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Utilisateur {

    @Id
    private String id;
    private String name;
    private String picture;
    private String locale;
    private String email;
    private Boolean email_verified;
    private String iss;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "projects")
    private List<Project> projects;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "submitted")
    private List<Ticket> submitted;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "assigned")
    private List<Ticket> assigned;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "comments")
    private List<Comment> comments;
}
