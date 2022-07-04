package auth.service.repository;

import auth.service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String userName);
    Boolean existsByUserName(String userName);
}
