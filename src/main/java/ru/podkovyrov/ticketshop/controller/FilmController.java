package ru.podkovyrov.ticketshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.podkovyrov.ticketshop.model.Film;
import ru.podkovyrov.ticketshop.model.Session;
import ru.podkovyrov.ticketshop.service.FilmService;
import ru.podkovyrov.ticketshop.service.SessionService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;

@Controller
public class FilmController {
    private final FilmService filmService;
    private final SessionService sessionService;

    @Autowired
    public FilmController(FilmService filmService, SessionService sessionService) {
        this.filmService = filmService;
        this.sessionService = sessionService;
    }

    @GetMapping("/addFilm")
    public String page(Model model){
        return "addFilm";
    }

    @PostMapping("/addFilm")
    public String addNewFilm(Model model, Film film){
        filmService.save(film);

        return "redirect:/";
    }

    @GetMapping("/film/{id}")
    public String film(Model model, @PathVariable(name = "id") Film film, @RequestParam(required = false, defaultValue = "") String date){

        if(!date.equals("")) {
            System.out.println(date);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDateTime lDate = LocalDateTime.parse(date + " 00:00" , formatter);
            System.out.println(lDate);
            model.addAttribute("date", date);
            List<Session> todaySession = this.sessionService.findAllByStartDateBetweenAndFilm(lDate, lDate.plusDays(1), film);


            todaySession.sort(Comparator.comparing(Session::getStartDate));
            model.addAttribute("sessions", todaySession);
        }
        model.addAttribute("film", film);


        return "film";
    }
}
