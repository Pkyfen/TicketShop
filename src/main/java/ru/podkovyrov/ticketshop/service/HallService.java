package ru.podkovyrov.ticketshop.service;

import ru.podkovyrov.ticketshop.model.Hall;

import java.util.List;

public interface HallService {
    List<Hall> findAll();
    void save(Hall hall);

    Hall findByNumber(String hallNumber);
}
