package finki.ukim.mk.emt.model.CreateDto;

import finki.ukim.mk.emt.model.domain.Category;

public record CreateAccommodationDTO(String name, Category category, Long hostId, Integer numRooms, String comment) {}