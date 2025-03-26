package finki.ukim.mk.emt.service;

import finki.ukim.mk.emt.model.Accomodation;
import finki.ukim.mk.emt.model.dto.AccomodationDTO;

import java.util.List;


public interface AccomodationService {
    List<Accomodation> getAllAccommodations();
    AccomodationDTO getAccommodationById(Long id);
    Accomodation addAccommodation(AccomodationDTO dto);
    Accomodation updateAccommodation(Long id, AccomodationDTO dto);
    void deleteAccommodation(Long id);
    void markAsRented(Long id);
}
