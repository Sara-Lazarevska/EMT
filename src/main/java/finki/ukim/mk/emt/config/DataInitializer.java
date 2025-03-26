package finki.ukim.mk.emt.config;

import finki.ukim.mk.emt.model.*;
import finki.ukim.mk.emt.repository.AccomodationRepository;
import finki.ukim.mk.emt.repository.CountryRepository;
import finki.ukim.mk.emt.repository.HostRepository;
import finki.ukim.mk.emt.repository.ReviewRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    private final AccomodationRepository accommodationRepository;
    private final HostRepository hostRepository;
    private final CountryRepository countryRepository;
    private final ReviewRepository reviewRepository;

    public DataInitializer(AccomodationRepository accommodationRepository, HostRepository hostRepository, CountryRepository countryRepository, ReviewRepository reviewRepository) {
        this.accommodationRepository = accommodationRepository;
        this.hostRepository = hostRepository;
        this.countryRepository = countryRepository;
        this.reviewRepository = reviewRepository;
    }

    @PostConstruct
    public void init() {
        Country usa = countryRepository.save(new Country(1l, "United States", "North America"));
        Country uk = countryRepository.save(new Country(2l, "United Kingdom", "Europe"));
        Country france = countryRepository.save(new Country(3l, "France", "Europe"));
        Country germany = countryRepository.save(new Country(null, "Germany", "Europe"));

        Host host1 = hostRepository.save(new Host(1l, "John", "Doe", usa));
        Host host2 = hostRepository.save(new Host(2l, "Emma", "Smith", uk));
        Host host3 = hostRepository.save(new Host(3l, "Pierre", "Dupont", france));
        Host host4 = hostRepository.save(new Host(null, "Hans", "Müller", germany));


        Accomodation a1 = accommodationRepository.save(new Accomodation(1l, "Cozy Apartment", Category.APARTMENT, host1, 2, false));
        Accomodation a2 = accommodationRepository.save(new Accomodation(2l, "Luxury Villa", Category.HOUSE, host2, 5, false));
        Accomodation a3 = accommodationRepository.save(new Accomodation(3l, "Downtown Studio", Category.ROOM, host3, 1, false));
        accommodationRepository.save(new Accomodation(null, "Modern Flat", Category.FLAT, host4, 3, false));
        accommodationRepository.save(new Accomodation(null, "Seaside Hotel", Category.HOTEL, host1, 50, false));
        accommodationRepository.save(new Accomodation(null, "Budget Motel", Category.MOTEL, host2, 20, false));

        Review review = reviewRepository.save(new Review(1l, "Comment1", 2, a1));
        Review review11 = reviewRepository.save(new Review(2l, "Comment1", 3, a1));
        Review review111 = reviewRepository.save(new Review(3l, "Comment1", 4, a1));

        Review review2 = reviewRepository.save(new Review(44l, "Comment2", 4, a2));
        Review review3 = reviewRepository.save(new Review(55l, "Comment3", 5, a3));
    }
}
