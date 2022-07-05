package auth.service.service;

import auth.service.model.User;

import java.util.List;

public interface GenericService {

    List<User> findAllUsers();
}