package com.yoaki.BugTracker.services.impl;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.yoaki.BugTracker.domain.Project;
import com.yoaki.BugTracker.domain.Ticket;
import com.yoaki.BugTracker.domain.dto.TicketDTO;
import com.yoaki.BugTracker.mappers.Mapper;
import com.yoaki.BugTracker.repositories.ProjectRepository;
import com.yoaki.BugTracker.repositories.TicketRepository;
import com.yoaki.BugTracker.services.TicketService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final ProjectRepository projectRepository;
    
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
    public List<TicketDTO> getAllTicketFor( Long projectId ) {
        Project project = projectRepository.findById(projectId).orElse(null);
        List<Ticket> tickets = ticketRepository.findByProject( project );
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
    public TicketDTO saveTicket(TicketDTO ticketDTO, Long projectId) {
        Ticket ticket = ticketMapper.mapFrom(ticketDTO);
        Project project = projectRepository.findById(projectId).orElse(null);

        ticket.setProject(project);

        String timeStamp = new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss").format(new java.util.Date());
        ticket.setCreatedAt(timeStamp);

        Ticket saveTicket = ticketRepository.save(ticket);
        return ticketMapper.mapTo(saveTicket);
    }

    @Override
    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
    }

    @Override
    public TicketDTO updateTicket(TicketDTO ticketDTO, Long projectId, Long id) {
        Project project = projectRepository.findById(projectId).orElse(null);
        Ticket existingTicket = ticketRepository.findById(id).orElse(null);
        Ticket newticket = ticketMapper.mapFrom(ticketDTO);

        existingTicket.setProject(project);

        existingTicket.setTitle(newticket.getTitle());
        existingTicket.setSubmitter(newticket.getSubmitter());
        existingTicket.setAssignedTo(newticket.getAssignedTo());
        existingTicket.setStatus(newticket.getStatus());
        existingTicket.setType(newticket.getType());
        existingTicket.setPriority(newticket.getPriority());

        String timeStamp = new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss").format(new java.util.Date());
        existingTicket.setUpdatedAt(timeStamp);


        Ticket saveTicket = ticketRepository.save(existingTicket);
        return ticketMapper.mapTo(saveTicket);
    }


     
}
