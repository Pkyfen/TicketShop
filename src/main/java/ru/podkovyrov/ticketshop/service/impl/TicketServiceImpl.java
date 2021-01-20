package ru.podkovyrov.ticketshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.podkovyrov.ticketshop.model.Session;
import ru.podkovyrov.ticketshop.model.Ticket;
import ru.podkovyrov.ticketshop.model.User;
import ru.podkovyrov.ticketshop.repository.TicketRepository;
import ru.podkovyrov.ticketshop.service.TicketService;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;

    @Autowired
    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public List<Ticket> findAllByUser(User user) {
        return this.ticketRepository.findAllByUser(user);
    }

    @Override
    public void save(Ticket ticket) {
        this.ticketRepository.save(ticket);
    }

    @Override
    public int countAllBySession(Session session) {
        return this.ticketRepository.countAllBySession(session);
    }

    @Override
    public List<Ticket> findAllBySession(Session session) {
        return this.ticketRepository.findAllBySession(session);
    }

    @Override
    public Ticket findByRowAndSeatAndSession(int row, int seat, Session session) {
        return this.ticketRepository.findByRowAndSeatAndSession(row,seat,session);
    }
}
