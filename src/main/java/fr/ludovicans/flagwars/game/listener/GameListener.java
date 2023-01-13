package fr.ludovicans.flagwars.game.listener;

import fr.ludovicans.flagwars.FlagWars;
import fr.ludovicans.flagwars.game.GameInstance;
import fr.ludovicans.flagwars.game.GamePlayer;
import fr.ludovicans.flagwars.game.GameSign;
import fr.ludovicans.flagwars.game.event.GamePlayerJoinEvent;
import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

@SuppressWarnings("unused")
public final class GameListener implements Listener {

    private final @NotNull FlagWars instance;

    public GameListener(@NotNull final FlagWars instance) {
        this.instance = instance;
    }

    /**
     * Vérifie que le {@link Block} est une instance de {@link Sign}.
     *
     * @param block à vérifier.
     * @return true si le {@link Block} est une instance de {@link Sign}.
     */
    private boolean isSign(final @NotNull Block block) {
        return (block instanceof Sign);
    }


    @EventHandler(priority = EventPriority.NORMAL)
    private void PlayerSignInteract(PlayerInteractEvent event) {
        // On vérifie que le bloc intéragit est un panneau.
        final Block clickedBlock = event.getClickedBlock();
        if (clickedBlock != null && !isSign(clickedBlock))
            return;

        // On essaye de récupérer un GameSign à partir du panneau.
        assert clickedBlock != null;
        final @NotNull Optional<GameSign> gameSign = instance.getGameManager().getGameSign((Sign) clickedBlock);
        if (gameSign.isEmpty())
            return;

        // On vérifie que le joueur n'est pas déjà dans une partie. (glitch prévention)
        if (instance.getGameManager().getGamePlayer(event.getPlayer()).isPresent())
            return;

        // On récupère l'instance de jeu associé au panneau.
        final @NotNull GameInstance gameInstance = gameSign.get().getGameInstance();

        // On créer une nouvelle instance de GamePlayer pour le joueur.
        final @NotNull GamePlayer gamePlayer = new GamePlayer(event.getPlayer());

        // On appelle l'évènement associé.
        Bukkit.getPluginManager().callEvent(new GamePlayerJoinEvent(gameInstance, gamePlayer));

        // On ajoute le joueur dans la partie.
        gameInstance.getGamePlayers().add(gamePlayer);

    }

}
