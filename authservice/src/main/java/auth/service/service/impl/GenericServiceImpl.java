package auth.service.service.impl;

import auth.service.model.User;
import auth.service.repository.UserRepository;
import auth.service.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GenericServiceImpl implements GenericService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAllUsers() {
        return (List<User>)userRepository.findAll();
    }

}