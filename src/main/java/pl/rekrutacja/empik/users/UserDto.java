package pl.rekrutacja.empik.users;

import java.time.LocalDateTime;

public record UserDto (
    String login,
    long id,
    String avatarUrl,
    String type,
    String name,
    int followers,
    int publicRepos,
    LocalDateTime createdAt
    )
{}
