package patryknope.homepokerek.Service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import patryknope.homepokerek.Model.Game;
import patryknope.homepokerek.Model.Player;
import patryknope.homepokerek.Repository.PlayerRepository;

import java.util.List;
import java.util.Set;


@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    public Player findPlayerById(Long id) {
        return playerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.valueOf(id)));
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Player addPlayer(Player player) {
        if (canPlayerBeAdded(player)) {
            return playerRepository.save(player);
        } else {
            return null; //TODO: throw exception
        }

    }

    public void deletePlayerById(Long id) {
        var playerToDelete = findPlayerById(id);
        playerRepository.deleteById(playerToDelete.getId());
    }

    public Player updatePlayer(Player player) {
        var playerToUpdate = findPlayerById(player.getId());
        playerToUpdate.setFirstName(player.getFirstName());
        playerToUpdate.setLastName(player.getFirstName());
        playerToUpdate.setEmail(player.getEmail());
        playerToUpdate.setTelephoneNumber(player.getTelephoneNumber());
        return playerRepository.save(playerToUpdate);
    }

    public Set<Game> getGamesOfPlayer(Long playerId) {
        var player = findPlayerById(playerId);
        if (player.getGameSet().size() == 0) {
            return Set.of();
        } else {
            return player.getGameSet();
        }

    }

    //helper function to determine if player can be deleted
    private boolean canPlayerBeAdded(Player player) {
        return !playerRepository.existsByEmail(player.getEmail()) &&
                !playerRepository.existsByTelephoneNumber(player.getTelephoneNumber());
    }
}
