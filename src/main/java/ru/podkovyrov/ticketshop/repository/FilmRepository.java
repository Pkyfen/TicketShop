package ru.podkovyrov.ticketshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.podkovyrov.ticketshop.model.Film;
import ru.podkovyrov.ticketshop.model.Status;

import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {
    List<Film> findAllByStatusEquals(Status status);
    Film findByName(String name);
}
