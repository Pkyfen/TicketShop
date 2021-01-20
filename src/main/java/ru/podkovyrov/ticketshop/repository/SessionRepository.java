package ru.podkovyrov.ticketshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.podkovyrov.ticketshop.model.Film;
import ru.podkovyrov.ticketshop.model.Session;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {
    List<Session> findAllByStartDateBetweenAndFilm(LocalDateTime from, LocalDateTime to, Film film);
}
