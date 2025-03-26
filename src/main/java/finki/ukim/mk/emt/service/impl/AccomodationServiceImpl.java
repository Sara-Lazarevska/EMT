package finki.ukim.mk.emt.service.impl;

import finki.ukim.mk.emt.model.Accomodation;
import finki.ukim.mk.emt.model.Category;
import finki.ukim.mk.emt.model.Host;
import finki.ukim.mk.emt.model.dto.AccomodationDTO;
import finki.ukim.mk.emt.repository.AccomodationRepository;
import finki.ukim.mk.emt.repository.HostRepository;
import finki.ukim.mk.emt.service.AccomodationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccomodationServiceImpl implements AccomodationService {

    private final AccomodationRepository accomodationRepository;
    private final HostRepository hostRepository;
    public AccomodationServiceImpl(AccomodationRepository accomodationRepository, HostRepository hostRepository) {
        this.accomodationRepository = accomodationRepository;
        this.hostRepository = hostRepository;
    }

    @Override
    public List<Accomodation> getAllAccommodations() {
        return accomodationRepository.findAll();
    }

    @Override
    public AccomodationDTO getAccommodationById(Long id) {
        Accomodation accommodation = accomodationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Accommodation not found"));
        return new AccomodationDTO(accommodation.getName(), accommodation.getCategory().name(), accommodation.getHost().getId(), accommodation.getNumRooms());
    }

    @Override
    public Accomodation addAccommodation(AccomodationDTO dto) {
        Accomodation accommodation = new Accomodation();
        accommodation.setName(dto.getName());
        accommodation.setCategory(Category.valueOf(dto.getCategory()));
        accommodation.setNumRooms(dto.getNumRooms());
        Host host = hostRepository.findById(dto.getHostID()).orElseThrow(() -> new RuntimeException("Host not found"));
        accommodation.setHost(host);
        return accomodationRepository.save(accommodation);
    }

    @Override
    public Accomodation updateAccommodation(Long id, AccomodationDTO dto) {
        Accomodation accommodation = accomodationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Accommodation not found"));
        accommodation.setName(dto.getName());
        accommodation.setCategory(Category.valueOf(dto.getCategory()));
        accommodation.setNumRooms(dto.getNumRooms());
        Host host = hostRepository.findById(dto.getHostID()).orElseThrow(() -> new RuntimeException("Host not found"));
        accommodation.setHost(host);
        return accomodationRepository.save(accommodation);
    }

    @Override
    public void deleteAccommodation(Long id) {
        accomodationRepository.deleteById(id);
    }

    @Override
    public void markAsRented(Long id) {
        Accomodation accommodation = accomodationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Accommodation not found"));
        accommodation.setRented(true);
        accomodationRepository.save(accommodation);
    }
}
