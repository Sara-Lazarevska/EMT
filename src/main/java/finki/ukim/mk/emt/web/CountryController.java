package finki.ukim.mk.emt.web;


import finki.ukim.mk.emt.model.domain.Country;
import finki.ukim.mk.emt.model.DisplayDto.CountryDTO;
import finki.ukim.mk.emt.service.CountryService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
public class CountryController {
    @Autowired
    private CountryService countryService;
    @Operation(summary = "Get all countries")
    @GetMapping
    public List<Country> getAllCountries() {
        return countryService.getAllCountries();
    }

    @Operation(summary = "Get country by ID")
    @GetMapping("/{id}")
    public ResponseEntity<CountryDTO> getCountryById(@PathVariable Long id) {
        return ResponseEntity.ok(countryService.getCountryById(id));
    }

    @Operation(summary = "Add new country")
    @PostMapping
    public ResponseEntity<CountryDTO> addCountry(@RequestBody CountryDTO dto) {
        countryService.addCountry(dto);
        return ResponseEntity.ok(dto);
    }

    @Operation(summary = "Update country by ID")
    @PutMapping("/{id}")
    public ResponseEntity<CountryDTO> updateCountry(@PathVariable Long id, @RequestBody CountryDTO dto) {
        countryService.updateCountry(id, dto);
        return ResponseEntity.ok(dto);
    }

    @Operation(summary = "Delete country by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCountry(@PathVariable Long id) {
        countryService.deleteCountry(id);
        return ResponseEntity.noContent().build();
    }
}
