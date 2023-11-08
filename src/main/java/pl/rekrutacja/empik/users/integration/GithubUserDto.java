package pl.rekrutacja.empik.users.integration;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public record GithubUserDto (
        String login,
        long id,
        @JsonProperty(value = "avatar_url")
        String avatarUrl,
        String type,
        String name,
        long followers,
        int publicRepos,
        @JsonProperty(value = "created_at")
        LocalDateTime createdAt
){

}
