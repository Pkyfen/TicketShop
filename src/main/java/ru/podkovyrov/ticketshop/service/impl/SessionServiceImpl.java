package ru.podkovyrov.ticketshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.podkovyrov.ticketshop.model.Film;
import ru.podkovyrov.ticketshop.model.Session;
import ru.podkovyrov.ticketshop.model.Ticket;
import ru.podkovyrov.ticketshop.repository.SessionRepository;
import ru.podkovyrov.ticketshop.service.SessionService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SessionServiceImpl implements SessionService {
    private final SessionRepository sessionRepository;

    @Autowired
    public SessionServiceImpl(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    @Override
    public List<Session> findAllByStartDateBetweenAndFilm(LocalDateTime from, LocalDateTime to, Film film) {
        return this.sessionRepository.findAllByStartDateBetweenAndFilm(from,to, film);
    }

    @Override
    public void save(Session session) {
        this.sessionRepository.save(session);
    }

    @Override
    public void delete(Session session) {
        this.sessionRepository.delete(session);
    }

}
