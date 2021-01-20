package ru.podkovyrov.ticketshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.podkovyrov.ticketshop.model.Film;
import ru.podkovyrov.ticketshop.model.Status;
import ru.podkovyrov.ticketshop.repository.FilmRepository;
import ru.podkovyrov.ticketshop.service.FilmService;

import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {
    private final FilmRepository filmRepository;

    @Autowired
    public FilmServiceImpl(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @Override
    public void save(Film film) {
        film.setStatus(Status.ACTIVE);
        this.filmRepository.save(film);
    }

    @Override
    public List<Film> findAll() {
        return this.filmRepository.findAll();
    }

    @Override
    public List<Film> findAllActive() {
        return this.filmRepository.findAllByStatusEquals(Status.ACTIVE);
    }

    @Override
    public Film findByName(String name) {
        return this.filmRepository.findByName(name);
    }
}
