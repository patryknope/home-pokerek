package patryknope.homepokerek.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import patryknope.homepokerek.Model.Game;
import patryknope.homepokerek.Model.Player;
import patryknope.homepokerek.Service.GameService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/games/")
public class GameController {

    @Autowired
    GameService gameService;

    @GetMapping("{id}")
    public Game getGameById(@PathVariable Long id) {
        return gameService.findGameById(id);
    }

    @GetMapping
    public List<Game> getAllGames() {
        return gameService.getAllGames();
    }

    @GetMapping("{id}")
    public Set<Player> getAllPlayersOfGame(@PathVariable Long id) {
        return gameService.getAllPlayersOfGame(id);
    }

    @PostMapping("{id}")
    public void addPlayerToGame(@RequestBody Player player, @PathVariable Long id) {
        gameService.addPlayerToGame(player, id);
    }

    @DeleteMapping("{id}")
    public void deleteGameById(@PathVariable Long id) {
        gameService.deleteGameById(id);
    }

}
