package ru.podkovyrov.ticketshop.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Data
public class Hall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number")
    int number;

    @Column(name = "number_of_seats")
    int numberOfSeats;

    @OneToMany(mappedBy = "hall" )
    private List<Session> sessions;
}

