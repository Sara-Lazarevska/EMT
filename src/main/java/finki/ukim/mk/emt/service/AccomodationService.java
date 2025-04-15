package finki.ukim.mk.emt.service;

import finki.ukim.mk.emt.model.domain.Accommodation;
import finki.ukim.mk.emt.model.CreateDto.AccomodationDTO;

import java.util.List;


public interface AccomodationService {
    List<Accommodation> getAllAccommodations();
    AccomodationDTO getAccommodationById(Long id);
    Accommodation addAccommodation(AccomodationDTO dto);
    Accommodation updateAccommodation(Long id, AccomodationDTO dto);
    void deleteAccommodation(Long id);
    void markAsRented(Long id);
}
