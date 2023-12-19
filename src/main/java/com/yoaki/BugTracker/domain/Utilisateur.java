package com.yoaki.BugTracker.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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

    @OneToMany(mappedBy = "manager" ,cascade = CascadeType.ALL)
    private List<Project> projects;

    @OneToMany(mappedBy = "submitter" ,cascade = CascadeType.ALL)
    private List<Ticket> submitted;

    @OneToMany(mappedBy = "assignedTo" ,cascade = CascadeType.ALL)
    private List<Ticket> assigned;

    @OneToMany(mappedBy = "commenter" ,cascade = CascadeType.ALL)
    private List<Comment> comments;
}
