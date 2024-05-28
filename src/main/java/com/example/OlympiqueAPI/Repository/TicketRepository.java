package com.example.OlympiqueAPI.Repository;

import com.example.OlympiqueAPI.Model.Ticket;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long>{
    
}
