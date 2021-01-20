package ru.podkovyrov.ticketshop.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.podkovyrov.ticketshop.model.User;

public interface UserService extends UserDetailsService {
    User findByLogin(String login);
    void save(User user);
}
