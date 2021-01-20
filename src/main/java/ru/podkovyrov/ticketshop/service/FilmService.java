package ru.podkovyrov.ticketshop.service;

import ru.podkovyrov.ticketshop.model.Film;

import java.util.List;

public interface FilmService {
    void save(Film film);
    List<Film> findAll();
    List<Film> findAllActive();
    Film findByName(String name);
}
