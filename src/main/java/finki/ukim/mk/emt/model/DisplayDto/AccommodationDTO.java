package finki.ukim.mk.emt.model.DisplayDto;

import finki.ukim.mk.emt.model.domain.Category;

public record AccommodationDTO(Long id, String name, Category category, String hostName, Integer numRooms, Integer rented, String comment) {}