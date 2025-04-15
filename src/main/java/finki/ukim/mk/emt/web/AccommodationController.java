package finki.ukim.mk.emt.web;

import finki.ukim.mk.emt.model.domain.Accommodation;
import finki.ukim.mk.emt.model.CreateDto.AccomodationDTO;
import finki.ukim.mk.emt.service.AccomodationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accommodations")
public class AccommodationController {
    @Autowired
    private AccomodationService accommodationService;

    @GetMapping
    public List<Accommodation> getAllAccommodations() {
        return accommodationService.getAllAccommodations();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccomodationDTO> getAccommodationById(@PathVariable Long id) {
        return ResponseEntity.ok(accommodationService.getAccommodationById(id));
    }

    @PostMapping
    public ResponseEntity<AccomodationDTO> addAccommodation(@RequestBody AccomodationDTO dto) {
        accommodationService.addAccommodation(dto);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccomodationDTO> updateAccommodation(@PathVariable Long id, @RequestBody AccomodationDTO dto) {
        accommodationService.updateAccommodation(id, dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccommodation(@PathVariable Long id) {
        accommodationService.deleteAccommodation(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/rent")
    public ResponseEntity<Void> markAsRented(@PathVariable Long id) {
        accommodationService.markAsRented(id);
        return ResponseEntity.noContent().build();
    }
}
