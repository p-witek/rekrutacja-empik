package pl.rekrutacja.empik.users;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import pl.rekrutacja.empik.users.integration.UserIntegration;

import java.util.Optional;

@Service
public class UserService {

    private final UserIntegration userIntegration;
    private final UserRequestLogRepository userRequestLogRepository;
    private final UserMapper userMapper;

    public UserService(UserIntegration userIntegration, UserRequestLogRepository userRequestLogRepository, UserMapper userMapper) {
        this.userIntegration = userIntegration;
        this.userRequestLogRepository = userRequestLogRepository;
        this.userMapper = userMapper;
    }

    @Transactional
    public GetUserDto getUser(String login) {
        UserDto userDto = userIntegration.getUser(login);
        Optional<UserRequestLog> requestLog = userRequestLogRepository.findByLogin(login)
                .or(() -> Optional.of(userMapper.toNewRequestLog(userDto)));
        requestLog.ifPresent(UserRequestLog::incrementRequestCount);
        userRequestLogRepository.save(requestLog.get());
        return userMapper.toDto(userDto);

    }
}
