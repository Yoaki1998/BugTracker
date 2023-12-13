package com.yoaki.BugTracker.services;

import java.util.List;

import com.yoaki.BugTracker.domain.dto.TicketDTO;

public interface TicketService {
    
    List<TicketDTO> getAllTicket();
    List<TicketDTO> getAllTicketFor(Long projectId);
    TicketDTO getTicketById(Long id);
    TicketDTO saveTicket(TicketDTO ticketDTO, Long projectId);

    //Unused
    void deleteTicket(Long id);
}
