package auth.service.service;


import auth.service.model.User;
import auth.service.model.UserDto;

import java.util.List;

public interface UserService {

    User save(UserDto user);
    List<User> findAll();
    User findById(Long id);
}
