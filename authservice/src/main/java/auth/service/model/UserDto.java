package auth.service.model;

import lombok.Data;

import java.util.List;

@Data
public class UserDto {

    private String username;
    private String password;
    private List<Role> roles;

}
