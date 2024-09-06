package pe.sermaluc.register.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.sermaluc.register.repository.entity.User;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RegisterRepository extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String email);
}
