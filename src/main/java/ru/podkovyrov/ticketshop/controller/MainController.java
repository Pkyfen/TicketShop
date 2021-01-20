package ru.podkovyrov.ticketshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.podkovyrov.ticketshop.model.Film;
import ru.podkovyrov.ticketshop.model.Status;
import ru.podkovyrov.ticketshop.service.FilmService;

import java.util.Map;

@Controller
public class MainController {
    private final FilmService filmService;


    @Autowired
    public MainController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping("/")
    public String mainPage(Model model){
        model.addAttribute("films", filmService.findAllActive());
        return "main";
    }

}
