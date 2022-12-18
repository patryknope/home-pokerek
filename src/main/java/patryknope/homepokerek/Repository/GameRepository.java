package patryknope.homepokerek.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import patryknope.homepokerek.Model.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

}
