package com.yoaki.BugTracker.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.yoaki.BugTracker.domain.Ticket;
import com.yoaki.BugTracker.domain.dto.TicketDTO;
import com.yoaki.BugTracker.mappers.Mapper;
import com.yoaki.BugTracker.repositories.TicketRepository;
import com.yoaki.BugTracker.services.TicketService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;
    private final Mapper<Ticket, TicketDTO> ticketMapper;

    @Override
    public List<TicketDTO> getAllTicket() {
        List<Ticket> tickets = ticketRepository.findAll();
        return tickets.stream()
        .map(ticketMapper::mapTo)
        .collect(Collectors.toList());
    }

    @Override
    public TicketDTO getTicketById(Long id) {
        Ticket ticket = ticketRepository.findById(id).orElse(null);
        return ticketMapper.mapTo(ticket);
    }

    @Override
    public TicketDTO saveTicket(TicketDTO ticketDTO) {
        Ticket ticket = ticketMapper.mapFrom(ticketDTO);
        Ticket saveTicket = ticketRepository.save(ticket);
        return ticketMapper.mapTo(saveTicket);
    }

    @Override
    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
    }
     
}
