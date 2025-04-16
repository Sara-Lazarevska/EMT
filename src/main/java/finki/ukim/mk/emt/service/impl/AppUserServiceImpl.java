package finki.ukim.mk.emt.service.impl;

import finki.ukim.mk.emt.model.DisplayDto.AppUserDTO;
import finki.ukim.mk.emt.model.DisplayDto.LoginDTO;
import finki.ukim.mk.emt.model.DisplayDto.RegisterDTO;
import finki.ukim.mk.emt.model.domain.AppUser;
import finki.ukim.mk.emt.repository.AppUserRepository;
import finki.ukim.mk.emt.service.AppUserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class AppUserServiceImpl implements AppUserService {

    private final AppUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AppUserServiceImpl(AppUserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void register(RegisterDTO dto) {
        AppUser user = new AppUser();
        user.setUsername(dto.getUsername());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setRole(dto.getRole());
        userRepository.save(user);
    }

    @Override
    public Optional<AppUser> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public String login(LoginDTO dto) {
        AppUser user = userRepository.findByUsername(dto.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));
        if (passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            return "Login successful";
        } else {
            throw new RuntimeException("Invalid password");
        }
    }
}
