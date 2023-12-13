package com.yoaki.BugTracker.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

import com.yoaki.BugTracker.domain.dto.TicketDTO;
import com.yoaki.BugTracker.services.TicketService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;





@RestController
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService ;

    @GetMapping("api/tickets")
    public List<TicketDTO> getAllTicket() {
        return ticketService.getAllTicket();
    }

    @GetMapping("api/projects/{projectId}/tickets")
    public List<TicketDTO> getAllTicketFor(@PathVariable Long projectId) {
        return ticketService.getAllTicketFor(projectId);
    }
    
    @PostMapping("api/projects/{projectId}/tickets")
    public TicketDTO saveTicket(@RequestBody TicketDTO ticketDTO, @PathVariable Long projectId) {
        return ticketService.saveTicket(ticketDTO, projectId);
    }
    
    @PutMapping("api/projects/{projectId}/tickets/{id}")
    public TicketDTO updateTicket(@RequestBody TicketDTO ticketDTO, @PathVariable Long projectId, @PathVariable Long id) {
        return ticketService.updateTicket(ticketDTO, projectId, id);
    }
    
    
}
