package finki.ukim.mk.emt.config;

import finki.ukim.mk.emt.model.Accomodation;
import finki.ukim.mk.emt.model.Category;
import finki.ukim.mk.emt.model.Country;
import finki.ukim.mk.emt.model.Host;
import finki.ukim.mk.emt.repository.AccomodationRepository;
import finki.ukim.mk.emt.repository.CountryRepository;
import finki.ukim.mk.emt.repository.HostRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    private final AccomodationRepository accommodationRepository;
    private final HostRepository hostRepository;
    private final CountryRepository countryRepository;

    public DataInitializer(AccomodationRepository accommodationRepository, HostRepository hostRepository, CountryRepository countryRepository) {
        this.accommodationRepository = accommodationRepository;
        this.hostRepository = hostRepository;
        this.countryRepository = countryRepository;
    }

    @PostConstruct
    public void init() {
        Country usa = countryRepository.save(new Country(null, "United States", "North America"));
        Country uk = countryRepository.save(new Country(null, "United Kingdom", "Europe"));
        Country france = countryRepository.save(new Country(null, "France", "Europe"));
        Country germany = countryRepository.save(new Country(null, "Germany", "Europe"));

        Host host1 = hostRepository.save(new Host(null, "John", "Doe", usa));
        Host host2 = hostRepository.save(new Host(null, "Emma", "Smith", uk));
        Host host3 = hostRepository.save(new Host(null, "Pierre", "Dupont", france));
        Host host4 = hostRepository.save(new Host(null, "Hans", "Müller", germany));

        accommodationRepository.save(new Accomodation(null, "Cozy Apartment", Category.APARTMENT, host1, 2, false));
        accommodationRepository.save(new Accomodation(null, "Luxury Villa", Category.HOUSE, host2, 5, false));
        accommodationRepository.save(new Accomodation(null, "Downtown Studio", Category.ROOM, host3, 1, false));
        accommodationRepository.save(new Accomodation(null, "Modern Flat", Category.FLAT, host4, 3, false));
        accommodationRepository.save(new Accomodation(null, "Seaside Hotel", Category.HOTEL, host1, 50, false));
        accommodationRepository.save(new Accomodation(null, "Budget Motel", Category.MOTEL, host2, 20, false));
    }
}
