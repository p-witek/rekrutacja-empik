package pl.rekrutacja.empik.users.integration;

import org.junit.jupiter.api.Test;
import pl.rekrutacja.empik.users.UserDto;

import static org.junit.jupiter.api.Assertions.*;

class GithubIntegrationTest {

    private final GithubUserMapper githubUserMapper = new GithubUserMapperImpl();
    private final GithubIntegration githubIntegration = new GithubIntegration(githubUserMapper);

    @Test
    void getUser_shouldReturnUserWithValidLogin() {
        //given
        String login = "SinusAlphaGames";
        //when
        UserDto userDto = githubIntegration.getUser(login);
        //then
        assertEquals(login, userDto.login());
    }
}