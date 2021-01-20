package ru.podkovyrov.ticketshop.service;

import org.springframework.stereotype.Service;
import ru.podkovyrov.ticketshop.model.Session;
import ru.podkovyrov.ticketshop.model.Ticket;
import ru.podkovyrov.ticketshop.model.User;

import java.util.List;

@Service
public interface TicketService {
    List<Ticket> findAllByUser(User user);
    void save(Ticket ticket);
    int countAllBySession(Session session);
    List<Ticket> findAllBySession(Session session);
    Ticket findByRowAndSeatAndSession(int row, int seat, Session session);

}
