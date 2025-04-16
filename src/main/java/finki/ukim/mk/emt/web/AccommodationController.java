package finki.ukim.mk.emt.web;

import finki.ukim.mk.emt.model.DisplayDto.AccommodationDTO;
import finki.ukim.mk.emt.model.domain.Accommodation;
import finki.ukim.mk.emt.service.AccommodationService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accommodations")
public class AccommodationController {
    @Autowired
    private AccommodationService accommodationService;

    @Operation(summary = "Get all accommodations")
    @GetMapping
    public List<Accommodation> getAllAccommodations() {
        return accommodationService.getAllAccommodations();
    }

    @Operation(summary = "Get accommodation by ID")
    @GetMapping("/{id}")
    public ResponseEntity<AccommodationDTO> getAccommodationById(@PathVariable Long id) {
        return ResponseEntity.ok(accommodationService.getAccommodationById(id));
    }

    @Operation(summary = "Add new accommodation")
    @PostMapping
    public ResponseEntity<AccommodationDTO> addAccommodation(@RequestBody AccommodationDTO dto) {
        accommodationService.addAccommodation(dto);
        return ResponseEntity.ok(dto);
    }

    @Operation(summary = "Update accommodation by ID")
    @PutMapping("/{id}")
    public ResponseEntity<AccommodationDTO> updateAccommodation(@PathVariable Long id, @RequestBody AccommodationDTO dto) {
        accommodationService.updateAccommodation(id, dto);
        return ResponseEntity.ok(dto);
    }

    @Operation(summary = "Delete accommodation by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccommodation(@PathVariable Long id) {
        accommodationService.deleteAccommodation(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Mark accommodation as rented")
    @PutMapping("/{id}/rent")
    public ResponseEntity<Void> markAsRented(@PathVariable Long id) {
        accommodationService.markAsRented(id);
        return ResponseEntity.noContent().build();
    }
}
