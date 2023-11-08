package pl.rekrutacja.empik.users;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRequestLogRepository extends CrudRepository<UserRequestLog, Long> {

    Optional<UserRequestLog> findByLogin(String login);

}
