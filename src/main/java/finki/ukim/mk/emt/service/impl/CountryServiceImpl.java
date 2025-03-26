package finki.ukim.mk.emt.service.impl;

import finki.ukim.mk.emt.model.Country;
import finki.ukim.mk.emt.model.dto.CountryDTO;
import finki.ukim.mk.emt.repository.CountryRepository;
import finki.ukim.mk.emt.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Override
    public CountryDTO getCountryById(Long id) {
        Country country = countryRepository.findById(id).orElseThrow(() -> new RuntimeException("Country not found"));
        return new CountryDTO(country.getName(), country.getContinent());
    }

    @Override
    public Country addCountry(CountryDTO dto) {
        Country country = new Country();
        country.setName(dto.getName());
        country.setContinent(dto.getContinent());
        return countryRepository.save(country);
    }

    @Override
    public Country updateCountry(Long id, CountryDTO dto) {
        Country country = countryRepository.findById(id).orElseThrow(() -> new RuntimeException("Country not found"));
        country.setName(dto.getName());
        country.setContinent(dto.getContinent());
        return countryRepository.save(country);
    }

    @Override
    public void deleteCountry(Long id) {
        countryRepository.deleteById(id);
    }
}
