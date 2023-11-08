package pl.rekrutacja.empik.users;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
    }


    @GetMapping(value = "/{login}")
    public GetUserDto getUser(@PathVariable String login) {
        return userService.getUser(login);
    }
}