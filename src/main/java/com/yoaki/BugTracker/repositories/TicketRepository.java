package com.yoaki.BugTracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yoaki.BugTracker.domain.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    
}
