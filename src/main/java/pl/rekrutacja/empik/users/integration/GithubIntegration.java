package pl.rekrutacja.empik.users.integration;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.rekrutacja.empik.users.UserDto;
import pl.rekrutacja.empik.users.integration.exceptions.GithubIntegrationErrorHandler;

@Component
public class GithubIntegration implements UserIntegration {

    private final GithubUserMapper githubUserMapper;

    public GithubIntegration(GithubUserMapper githubUserMapper) {
        this.githubUserMapper = githubUserMapper;
    }

    public UserDto getUser(String login) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(new GithubIntegrationErrorHandler());
        String url = "https://api.github.com/users/" + login;
        ResponseEntity<GithubUserDto> response = restTemplate.getForEntity(url, GithubUserDto.class);
        return githubUserMapper.toUserDto(response.getBody());
    }
}
