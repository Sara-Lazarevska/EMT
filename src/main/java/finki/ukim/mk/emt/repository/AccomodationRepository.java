package finki.ukim.mk.emt.repository;

import finki.ukim.mk.emt.model.Accomodation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccomodationRepository extends JpaRepository<Accomodation, Long> {
}
