package ru.podkovyrov.ticketshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.podkovyrov.ticketshop.model.Film;
import ru.podkovyrov.ticketshop.model.Session;
import ru.podkovyrov.ticketshop.model.Ticket;
import ru.podkovyrov.ticketshop.model.User;
import ru.podkovyrov.ticketshop.service.FilmService;
import ru.podkovyrov.ticketshop.service.HallService;
import ru.podkovyrov.ticketshop.service.SessionService;
import ru.podkovyrov.ticketshop.service.TicketService;

import java.nio.file.attribute.UserPrincipal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Controller
public class SessionController {

    private final SessionService sessionService;
    private final HallService hallService;
    private final FilmService filmService;
    private final TicketService ticketService;

    @Autowired
    public SessionController(SessionService sessionService, HallService hallService, FilmService filmService, TicketService ticketService) {
        this.sessionService = sessionService;
        this.hallService = hallService;
        this.filmService = filmService;
        this.ticketService = ticketService;
    }

    @GetMapping("/addSession")
    public String page(Model model){
        model.addAttribute("films", filmService.findAllActive());
        model.addAttribute("halls", hallService.findAll());
        return "addSession";
    }

    @PostMapping("/addSession")
    public String addNewSession(Model model, String filmName, String hallNumber, String date, String time ){

        Session session = new Session();
        Film film = filmService.findByName(filmName);
        session.setFilm(film);
        session.setHall(hallService.findByNumber(hallNumber));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(date + " " + time, formatter);

        session.setStartDate(dateTime);

        this.sessionService.save(session);
        return "redirect:/film/" + film.getId()+"?date="+date;
    }

    @PostMapping("/sessions/delete/{id}")
    public String deleteSession(Model model, @PathVariable(name = "id") Session session, String date){
        System.out.println("DELETE " + session.getStartDate());
        this.sessionService.delete(session);

        return "redirect:/film/" + session.getFilm().getId()+"?date="+date;
    }

    @GetMapping("/sessions/{id}")
    public String pageSession(Model model, @PathVariable(name = "id") Session session){
        model.addAttribute("film", session.getFilm());
        List<Ticket> buyTickets =  ticketService.findAllBySession(session);
        buyTickets.sort(Comparator.comparingInt((Ticket f) -> f.getRow() * 4 + f.getSeat()));

        boolean flag = false;
        List<Ticket> tickets = new ArrayList<>();
        for(int i=0; i<4; i++){
            for(int j=0; j<5; j++){
                for (Ticket t : buyTickets) {
                    if (t.getRow()*4+t.getSeat() + t.getRow() == i*4+j+i) {
                        tickets.add(t);
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    tickets.add(new Ticket());
                }else{
                    flag = false;
                }
            }
        }

        model.addAttribute("tickets", tickets);
        model.addAttribute("countOfBuyTickets", ticketService.countAllBySession(session));
        model.addAttribute("session", session);

        System.out.println(ticketService.findAllBySession(session).size());
        return "sessions";
    }

    @PostMapping("/sessions/{id}/buy")
    public String buySession(Model model, @PathVariable(name = "id") Session session, String row, String seat){
        Ticket ticketFromBd = ticketService.findByRowAndSeatAndSession(Integer.parseInt(row)-1, Integer.parseInt(seat)-1, session);
        if(ticketFromBd!=null) {
            model.addAttribute("message", "Место уже занято!");
            System.out.println("ой");
            return "redirect:/sessions/"+session.getId();
        }
        Ticket ticket = new Ticket();
        ticket.setRow(Integer.parseInt(row)-1);
        ticket.setSeat(Integer.parseInt(seat)-1);
        ticket.setSession(session);
        User userPrincipal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ticket.setUser(userPrincipal);

        ticketService.save(ticket);
        return "redirect:/tickets";
    }
}
