package ru.podkovyrov.ticketshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.podkovyrov.ticketshop.model.Film;
import ru.podkovyrov.ticketshop.service.FilmService;

import java.util.List;

@RestController
public class TestController {
    private final FilmService filmService;

    @Autowired
    public TestController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping("/test")
    public List<Film> findAll(){
        return filmService.findAll();
    }

    @GetMapping("/test/s")
    public List<Film> findAlls(){
        return filmService.findAllActive();
    }
}
