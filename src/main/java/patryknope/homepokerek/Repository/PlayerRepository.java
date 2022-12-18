package patryknope.homepokerek.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import patryknope.homepokerek.Model.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {

    boolean existsByEmail(String email);

    boolean existsByTelephoneNumber(String telephoneNumber);
}
