package ru.podkovyrov.ticketshop.service;

import ru.podkovyrov.ticketshop.model.Film;
import ru.podkovyrov.ticketshop.model.Session;
import ru.podkovyrov.ticketshop.model.Ticket;

import java.time.LocalDateTime;
import java.util.List;

public interface SessionService {
    List<Session> findAllByStartDateBetweenAndFilm(LocalDateTime from, LocalDateTime to, Film film  );
    void save(Session session);
    void delete(Session session);
}
