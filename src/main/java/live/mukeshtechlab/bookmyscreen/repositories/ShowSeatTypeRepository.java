package live.mukeshtechlab.bookmyscreen.repositories;

import live.mukeshtechlab.bookmyscreen.models.Show;
import live.mukeshtechlab.bookmyscreen.models.ShowSeatType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatTypeRepository extends JpaRepository <ShowSeatType, Long>{
    List<ShowSeatType> findAllByShow(Show show);
}
