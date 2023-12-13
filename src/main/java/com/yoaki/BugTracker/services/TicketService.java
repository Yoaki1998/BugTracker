package com.yoaki.BugTracker.services;

import java.util.List;

import com.yoaki.BugTracker.domain.dto.TicketDTO;

public interface TicketService {
    
    List<TicketDTO> getAllTicket();
    TicketDTO getTicketById(Long id);
    TicketDTO saveTicket(TicketDTO ticketDTO);
    void deleteTicket(Long id);
}
