package pl.rekrutacja.empik.users;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = ".", target = "calculations", qualifiedByName = "mapCalculations")
    GetUserDto toDto(UserDto userDto);

    @Named("mapCalculations")
    default double mapCalculations(UserDto userDto) {
        return new Calculator(userDto.followers(), userDto.publicRepos()).calculate();
    }

    UserRequestLog toNewRequestLog(UserDto userDto);
}
