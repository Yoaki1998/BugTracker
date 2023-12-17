package com.yoaki.BugTracker.domain;

import java.util.List;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

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

    @Cascade(CascadeType.ALL)
    @OneToMany(mappedBy = "utilisateur")
    private List<Project> projects;

    @Cascade(CascadeType.ALL)
    @OneToMany(mappedBy = "submitter")
    private List<Ticket> submittedTickets;

    @Cascade(CascadeType.ALL)
    @OneToMany(mappedBy = "assignedTo")
    private List<Ticket> assignedTickets;

}
