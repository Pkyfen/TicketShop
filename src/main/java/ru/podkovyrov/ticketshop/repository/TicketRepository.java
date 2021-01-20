package ru.podkovyrov.ticketshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.podkovyrov.ticketshop.model.Session;
import ru.podkovyrov.ticketshop.model.Ticket;
import ru.podkovyrov.ticketshop.model.User;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    int countAllBySession(Session session);
    List<Ticket> findAllByUser(User user);
    List<Ticket> findAllBySession(Session session);
    Ticket findByRowAndSeatAndSession(int row, int seat, Session session);
}
