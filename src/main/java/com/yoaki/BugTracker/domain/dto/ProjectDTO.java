package com.yoaki.BugTracker.domain.dto;



import java.util.List;

import lombok.Data;

@Data
public class ProjectDTO {

    private Long id;
    private String name;
    private String description;
    private String manager;

    private List<TicketDTO> tickets;

}
