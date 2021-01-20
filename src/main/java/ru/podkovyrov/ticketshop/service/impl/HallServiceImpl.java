package ru.podkovyrov.ticketshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.podkovyrov.ticketshop.model.Hall;
import ru.podkovyrov.ticketshop.repository.HallRepository;
import ru.podkovyrov.ticketshop.service.HallService;

import java.util.List;

@Service
public class HallServiceImpl implements HallService {
    private final HallRepository hallRepository;

    @Autowired
    public HallServiceImpl(HallRepository hallRepository) {
        this.hallRepository = hallRepository;
    }

    @Override
    public List<Hall> findAll() {
        return this.hallRepository.findAll();
    }

    @Override
    public void save(Hall hall) {
        this.hallRepository.save(hall);
    }

    @Override
    public Hall findByNumber(String hallNumber) {
        return this.hallRepository.findByNumber(Integer.parseInt(hallNumber));
    }
}
