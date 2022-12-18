package patryknope.homepokerek.Service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import patryknope.homepokerek.Model.Game;
import patryknope.homepokerek.Model.Player;
import patryknope.homepokerek.Repository.GameRepository;

import java.util.List;
import java.util.Set;

@Service
public class GameService {
    @Autowired
    GameRepository gameRepository;

    public Game findGameById(Long id) {
        return gameRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.valueOf(id)));
    }

    public void deleteGameById(Long id) {
        var gameToDelete = findGameById(id);
        gameRepository.deleteById(gameToDelete.getId());
    }

    public Set<Player> getAllPlayersOfGame(Long id) {
        var game = findGameById(id);
        if (!game.getPlayerSet().isEmpty()) {
            return game.getPlayerSet();
        } else {
            return Set.of();
        }
    }

    public void addPlayerToGame(Player player, Long gameId) {
        var game = findGameById(gameId);
        game.getPlayerSet().add(player);
    }

    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

}
