package pl.rekrutacja.empik.users.integration;

import pl.rekrutacja.empik.users.UserDto;

public interface UserIntegration {

    UserDto getUser(String login);
}
