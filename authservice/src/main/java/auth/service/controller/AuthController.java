package auth.service.controller;

import auth.service.model.MessageResponse;
import auth.service.model.RandomCity;
import auth.service.model.Role;
import auth.service.model.User;
import auth.service.repository.RoleRepository;
import auth.service.repository.UserRepository;
import auth.service.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
    @RequestMapping("/springjwt")
    public class AuthController {
        @Autowired
        private GenericService userService;


        @Autowired
        private RoleRepository roleRepository;

        @Autowired
        UserRepository userRepository;



        @Autowired
        PasswordEncoder encoder;

        @RequestMapping(value ="/cities")
        @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
        public List<RandomCity> getUser(){
            return userService.findAllRandomCities();
        }

        @RequestMapping(value ="/users", method = RequestMethod.GET)
        @PreAuthorize("hasAuthority('ADMIN_USER')")
        public List<User> getUsers(){

            return userService.findAllUsers();
        }


        @PostMapping("/signup")
        public ResponseEntity<?> registerUser(@RequestBody User signUpRequest) {
            if (userRepository.existsByUserName(signUpRequest.getUserName())) {
                return ResponseEntity
                        .badRequest()
                        .body(new MessageResponse("Error: Username is already taken!"));
            }

            List<Role> receivedRoles = signUpRequest.getRoles();
            if (receivedRoles==null || receivedRoles.isEmpty()) {
                receivedRoles=new ArrayList<>();
                Role userRole =new Role();
                userRole.setRoleName("ROLE_USER");
                receivedRoles.add(userRole);
                signUpRequest.setRoles(receivedRoles);
                if(!roleRepository.existsByRoleName("ROLE_USER"))
                     roleRepository.saveAll(receivedRoles);
            }
            else {

                receivedRoles.forEach((role)  ->{
                        if(!roleRepository.existsByRoleName(role.getRoleName()))
                            roleRepository.save(role);
                });

            }
            signUpRequest.setPassword(encoder.encode(signUpRequest.getPassword()));
            userRepository.save(signUpRequest);

            return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
        }
}
