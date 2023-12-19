package com.yoaki.BugTracker.services;

import java.util.List;

import com.yoaki.BugTracker.domain.dto.TicketDTO;

public interface TicketService {
    
    List<TicketDTO> getAllTicket();
    TicketDTO getTicketById(Long projectId, Long id);
    TicketDTO saveTicket(TicketDTO ticketDTO, Long projectId);
    TicketDTO updateTicket(TicketDTO ticketDTO, Long projectId, Long id);

    //Unused
    void deleteTicket(Long id);
}
