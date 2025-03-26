package finki.ukim.mk.emt.service;

import finki.ukim.mk.emt.model.Country;
import finki.ukim.mk.emt.model.dto.CountryDTO;

import java.util.List;

public interface CountryService {
    List<Country> getAllCountries();
    CountryDTO getCountryById(Long id);
    Country addCountry(CountryDTO dto);
    Country updateCountry(Long id, CountryDTO dto);
    void deleteCountry(Long id);
}
