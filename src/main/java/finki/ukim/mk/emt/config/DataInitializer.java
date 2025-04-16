package finki.ukim.mk.emt.config;

import finki.ukim.mk.emt.model.domain.*;
import finki.ukim.mk.emt.model.enumerations.Category;
import finki.ukim.mk.emt.model.enumerations.Role;
import finki.ukim.mk.emt.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(AccommodationRepository accommodationRepository,
                                   HostRepository hostRepository,
                                   CountryRepository countryRepository,
                                   ReviewRepository reviewRepository,
                                   AppUserRepository userRepository,
                                   PasswordEncoder passwordEncoder) {
        return args -> {
            // === Countries ===
            Country usa = new Country(1L, "United States", "North America");
            Country france = new Country(2L, "France", "Europe");
            countryRepository.saveAll(List.of(usa, france));

            // === Hosts ===
            Host host1 = new Host(1L, "John", "Doe", usa);
            Host host2 = new Host(2L, "Pierre", "Dupont", france);
            hostRepository.saveAll(List.of(host1, host2));

            // === Accommodations ===
            Accommodation acc1 = new Accommodation(1L, "Cozy Apartment", Category.APARTMENT, host1, 2, 0, "Perfect for couples");
            Accommodation acc2 = new Accommodation(2L, "Luxury Villa", Category.HOUSE, host2, 5, 1, "Private pool and BBQ area");
            Accommodation acc3 = new Accommodation(3L, "Downtown Studio", Category.ROOM, host1, 1, 0, "Compact and convenient");
            accommodationRepository.saveAll(List.of(acc1, acc2, acc3));

            // === Reviews ===
            Review r1 = new Review(1L, "Super cozy and clean!", 5, acc1);
            Review r2 = new Review(2L, "Had an amazing weekend.", 4, acc2);
            Review r3 = new Review(3L, "Small but had everything I needed.", 3, acc3);
            Review r4 = new Review(4L, "Could be cleaner.", 2, acc3);
            reviewRepository.saveAll(List.of(r1, r2, r3, r4));

            // === App Users ===
            AppUser user1 = new AppUser();
            user1.setUsername("john");
            user1.setPassword(passwordEncoder.encode("123"));
            user1.setRole(Role.USER);

            AppUser user2 = new AppUser();
            user2.setUsername("jane_smith");
            user2.setPassword(passwordEncoder.encode("securepass"));
            user2.setRole(Role.USER);

            AppUser hostUser = new AppUser();
            hostUser.setUsername("host_elena");
            hostUser.setPassword(passwordEncoder.encode("hostpass"));
            hostUser.setRole(Role.HOST);

            userRepository.saveAll(List.of(user1, user2, hostUser));
        };
    }
}
