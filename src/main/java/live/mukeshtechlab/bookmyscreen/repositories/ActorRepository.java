package live.mukeshtechlab.bookmyscreen.repositories;

import live.mukeshtechlab.bookmyscreen.models.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {
}
