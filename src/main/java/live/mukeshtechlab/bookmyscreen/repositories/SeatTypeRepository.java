package live.mukeshtechlab.bookmyscreen.repositories;

import live.mukeshtechlab.bookmyscreen.models.SeatType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatTypeRepository extends JpaRepository<SeatType, Long> {
}
