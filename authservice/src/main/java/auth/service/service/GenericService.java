package auth.service.service;

import auth.service.model.RandomCity;
import auth.service.model.User;

import java.util.List;

public interface GenericService {
    User findByUsername(String username);

    List<User> findAllUsers();

    List<RandomCity> findAllRandomCities();
}