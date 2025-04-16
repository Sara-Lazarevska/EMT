package finki.ukim.mk.emt.service.impl;

import finki.ukim.mk.emt.model.DisplayDto.AccommodationDTO;
import finki.ukim.mk.emt.model.domain.Accommodation;
import finki.ukim.mk.emt.model.enumerations.Category;
import finki.ukim.mk.emt.model.domain.Host;
import finki.ukim.mk.emt.repository.AccommodationRepository;
import finki.ukim.mk.emt.repository.HostRepository;
import finki.ukim.mk.emt.service.AccommodationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccomodationServiceImpl implements AccommodationService {

    private final AccommodationRepository accommodationRepository;
    private final HostRepository hostRepository;
    public AccomodationServiceImpl(AccommodationRepository accommodationRepository, HostRepository hostRepository) {
        this.accommodationRepository = accommodationRepository;
        this.hostRepository = hostRepository;
    }

    @Override
    public List<Accommodation> getAllAccommodations() {
        return accommodationRepository.findAll();
    }

    @Override
    public AccommodationDTO getAccommodationById(Long id) {
        Accommodation accommodation = accommodationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Accommodation not found"));
        return new AccommodationDTO(accommodation.getName(), accommodation.getCategory().name(), accommodation.getHost().getId(), accommodation.getNumRooms());
    }

    @Override
    public Accommodation addAccommodation(AccommodationDTO dto) {
        Accommodation accommodation = new Accommodation();
        accommodation.setName(dto.getName());
        accommodation.setCategory(Category.valueOf(String.valueOf(dto.getCategory())));
        accommodation.setNumRooms(dto.getNumRooms());
        Host host = hostRepository.findById(dto.getHostId()).orElseThrow(() -> new RuntimeException("Host not found"));
        accommodation.setHost(host);
        return accommodationRepository.save(accommodation);
    }

    @Override
    public Accommodation updateAccommodation(Long id, AccommodationDTO dto) {
        Accommodation accommodation = accommodationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Accommodation not found"));
        accommodation.setName(dto.getName());
        accommodation.setCategory(Category.valueOf(String.valueOf(dto.getCategory())));
        accommodation.setNumRooms(dto.getNumRooms());
        Host host = hostRepository.findById(dto.getHostId()).orElseThrow(() -> new RuntimeException("Host not found"));
        accommodation.setHost(host);
        return accommodationRepository.save(accommodation);
    }

    @Override
    public void deleteAccommodation(Long id) {
        accommodationRepository.deleteById(id);
    }

    @Override
    public void markAsRented(Long id) {
        Accommodation accommodation = accommodationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Accommodation not found"));

        if (accommodation.getRented() >= accommodation.getNumRooms()) {
            throw new RuntimeException("All rooms in this accommodation are already rented.");
        }

        accommodation.setRented(accommodation.getRented() + 1);
        accommodationRepository.save(accommodation);
    }
}
