package pl.rekrutacja.empik.users;

import java.time.LocalDateTime;

public record GetUserDto(
        long id,
        String login,
        String name,
        String type,
        String avatarUrl,
        LocalDateTime createdAt,
        double calculations) {

}
