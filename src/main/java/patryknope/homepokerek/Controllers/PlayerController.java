package patryknope.homepokerek.Controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import patryknope.homepokerek.Model.Game;
import patryknope.homepokerek.Model.Player;
import patryknope.homepokerek.Service.PlayerService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/players/")
public class PlayerController {
    @Autowired
    PlayerService playerService;

    @GetMapping("{id}")
    public Player getPlayer(@PathVariable Long id) {
        return playerService.findPlayerById(id);
    }

    @GetMapping
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping("{id}/games")
    public Set<Game> getGamesOfPlayer(@PathVariable Long id) {
        return playerService.getGamesOfPlayer(id);
    }

    @PostMapping
    public Player addPlayer(@Valid @RequestBody Player player) {
        return playerService.addPlayer(player);
    }

    @PutMapping
    public Player updatePlayer(@Valid @RequestBody Player player) {
        return playerService.updatePlayer(player);
    }

    @DeleteMapping("{id}")
    public void deletePlayer(@PathVariable Long id) {
        playerService.deletePlayerById(id);
    }

}
