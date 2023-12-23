package com.yoaki.BugTracker.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

import com.yoaki.BugTracker.domain.dto.TicketDTO;
import com.yoaki.BugTracker.services.TicketService;







@RestController
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService ;

    @GetMapping("api/tickets")
    public List<TicketDTO> getAllTicket() {
        return ticketService.getAllTicket();
    }
    
    @PostMapping("api/projects/{projectId}/tickets")
    public TicketDTO saveTicket(@RequestBody TicketDTO ticketDTO, @PathVariable Long projectId) {
        return ticketService.saveTicket(ticketDTO, projectId);
    }
    
    @PutMapping("api/projects/{projectId}/tickets/{id}")
    public TicketDTO updateTicket(@RequestBody TicketDTO ticketDTO, @PathVariable Long projectId, @PathVariable Long id) {
        return ticketService.updateTicket(ticketDTO, projectId, id);
    }
    
    @GetMapping("api/tickets/{id}")
    public TicketDTO getTicketById( @PathVariable Long id) {
        return  ticketService.getTicketById(id);
    }
    
}
