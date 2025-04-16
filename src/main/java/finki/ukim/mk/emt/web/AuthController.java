package finki.ukim.mk.emt.web;

import finki.ukim.mk.emt.model.DisplayDto.LoginDTO;
import finki.ukim.mk.emt.model.DisplayDto.RegisterDTO;
import finki.ukim.mk.emt.service.AppUserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AppUserService userService;

    public AuthController(AppUserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Register new user")
    @PostMapping("/register")
    public String register(@RequestBody RegisterDTO dto) {
        userService.register(dto);
        return "User registered!";
    }

    @Operation(summary = "Login user")
    @PostMapping("/login")
    public String login(@RequestBody LoginDTO dto) {
        return userService.login(dto);
    }
}
