package live.mukeshtechlab.bookmyscreen.repositories;

import live.mukeshtechlab.bookmyscreen.models.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
}
