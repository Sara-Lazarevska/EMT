package finki.ukim.mk.emt.service;

import finki.ukim.mk.emt.model.DisplayDto.AppUserDTO;
import finki.ukim.mk.emt.model.DisplayDto.LoginDTO;
import finki.ukim.mk.emt.model.DisplayDto.RegisterDTO;
import finki.ukim.mk.emt.model.domain.AppUser;

import java.util.Optional;

public interface AppUserService {
    void register(RegisterDTO dto); // Method to register a user

    String login(LoginDTO dto); // Method to login a user
}
