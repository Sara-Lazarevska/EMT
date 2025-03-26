package finki.ukim.mk.emt.web;


import finki.ukim.mk.emt.model.Country;
import finki.ukim.mk.emt.model.dto.CountryDTO;
import finki.ukim.mk.emt.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
public class CountryController {
    @Autowired
    private CountryService countryService;

    @GetMapping
    public List<Country> getAllCountries() {
        return countryService.getAllCountries();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CountryDTO> getCountryById(@PathVariable Long id) {
        return ResponseEntity.ok(countryService.getCountryById(id));
    }

    @PostMapping
    public ResponseEntity<CountryDTO> addCountry(@RequestBody CountryDTO dto) {
        countryService.addCountry(dto);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CountryDTO> updateCountry(@PathVariable Long id, @RequestBody CountryDTO dto) {
        countryService.updateCountry(id, dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCountry(@PathVariable Long id) {
        countryService.deleteCountry(id);
        return ResponseEntity.noContent().build();
    }
}
