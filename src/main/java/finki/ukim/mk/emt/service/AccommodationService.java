package finki.ukim.mk.emt.service;

import finki.ukim.mk.emt.model.DisplayDto.AccommodationDTO;
import finki.ukim.mk.emt.model.domain.Accommodation;


import java.util.List;


public interface AccommodationService {
    List<Accommodation> getAllAccommodations();
    AccommodationDTO getAccommodationById(Long id);
    Accommodation addAccommodation(AccommodationDTO dto);
    Accommodation updateAccommodation(Long id, AccommodationDTO dto);
    void deleteAccommodation(Long id);
    void markAsRented(Long id);
}
