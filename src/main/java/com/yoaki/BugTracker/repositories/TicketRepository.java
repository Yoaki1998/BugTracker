package com.yoaki.BugTracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yoaki.BugTracker.domain.Project;
import com.yoaki.BugTracker.domain.Ticket;
import java.util.List;


public interface TicketRepository extends JpaRepository<Ticket, Long> {

    
}
