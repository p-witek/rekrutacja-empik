package pl.rekrutacja.empik.users.integration;

import org.mapstruct.Mapper;
import pl.rekrutacja.empik.users.UserDto;

@Mapper(componentModel = "spring")
public interface GithubUserMapper {

    UserDto toUserDto(GithubUserDto githubUserDto);
}
