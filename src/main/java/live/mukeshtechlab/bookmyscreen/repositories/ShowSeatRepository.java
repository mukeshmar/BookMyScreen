package live.mukeshtechlab.bookmyscreen.repositories;

import live.mukeshtechlab.bookmyscreen.models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {
    List<ShowSeat> findAllByIdIn(List<Long> ids);
}
