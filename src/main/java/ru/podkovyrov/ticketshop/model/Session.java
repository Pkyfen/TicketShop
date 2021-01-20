package ru.podkovyrov.ticketshop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Entity
@Table
@Data
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "film_id")
    private Film film;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "hall_id")
    private Hall hall;

    @OneToMany(mappedBy = "session" )
    private List<Ticket> tickets;


    public String getTime(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return startDate.format(formatter);
    }

    public String getDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return startDate.format(formatter);
    }

    public boolean isEnd(){
        return LocalDateTime.now().isAfter(startDate);
    }

    public int countOfBuyTicket() {
        return this.tickets.size();
    }
}
