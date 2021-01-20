package ru.podkovyrov.ticketshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.podkovyrov.ticketshop.model.Hall;

@Repository
public interface HallRepository extends JpaRepository<Hall, Long> {
    Hall findByNumber(int number);
}
