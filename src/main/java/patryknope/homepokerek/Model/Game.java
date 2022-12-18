package patryknope.homepokerek.Model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate gameDate;
    private LocalDateTime gameStart;
    private LocalDateTime gameEnd;
    @ManyToMany
    @JoinTable(
            name="players_in_game",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "player_id")
    )
    Set<Player> playerSet = new HashSet<>();

}
