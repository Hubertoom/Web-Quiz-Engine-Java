package engine.repository;

import engine.model.AppUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<AppUser, Long> {

    Optional<AppUser> findAppUserByUsername(String username);

    Optional<AppUser> findAUserByEmail(String email);
}
