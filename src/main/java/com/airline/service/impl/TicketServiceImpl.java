package com.airline.service.impl;

import com.airline.converter.TicketConverter;
import com.airline.dto.ticketDto.response.TicketDtoRes;
import com.airline.entity.Ticket;
import com.airline.repository.TicketRepository;
import com.airline.service.TicketService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TicketServiceImpl implements TicketService {
    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    TicketConverter ticketConverter;

    @Override
    public List<Ticket> findALlTicketPage(String name, Pageable pageable) {
        return null;
    }

    @Override
    public TicketDtoRes getTicketDtoResById(Long id) {
        Ticket ticket = ticketRepository.getTicketById(id);
        TicketDtoRes res = ticketConverter.entityToDto(ticket);
        return res;
    }
}