package com.yoaki.BugTracker.mappers.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.yoaki.BugTracker.domain.Ticket;
import com.yoaki.BugTracker.domain.dto.TicketDTO;
import com.yoaki.BugTracker.mappers.Mapper;

@Component
public class TicketMapperImpl implements Mapper<Ticket, TicketDTO> {

    private ModelMapper modelMapper;

    public TicketMapperImpl (ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public TicketDTO mapTo(Ticket ticket) {
        return modelMapper.map(ticket, TicketDTO.class);
    }

    @Override
    public Ticket mapFrom(TicketDTO TicketDTO) {
        return modelMapper.map(TicketDTO, Ticket.class);
    }
    
}
