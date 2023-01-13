package fr.ludovicans.flagwars.game;

import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@SuppressWarnings("unused")
public final class GameManager {

    private final @NotNull List<GameInstance> gameInstanceList;

    public GameManager(final @NotNull List<GameInstance> gameInstanceList) {
        this.gameInstanceList = gameInstanceList;
    }

    public GameManager() {
        this.gameInstanceList = new ArrayList<>();
    }

    public @NotNull List<GameInstance> getGameInstanceList() {
        return gameInstanceList;
    }

    public void addGameInstance(final @NotNull GameInstance gameInstance) {
        gameInstanceList.add(gameInstance);
    }

    /**
     * Permet de récupérer un {@link GameSign} en donnant un {@link Sign} bloc en paramètre.
     *
     * @param sign associé au {@link GameSign}.
     * @return le {@link GameSign} associé au sign.
     */
    public Optional<GameSign> getGameSign(final @NotNull Sign sign) {
        return getGameInstanceList()
                .stream()
                .map(GameInstance::getGameSignList)
                .map(gameSigns -> {
                    for (GameSign gameSign : gameSigns) {
                        return gameSign;
                    }
                    return null;
                })
                .filter(Objects::nonNull)
                .filter(gameSign -> gameSign.isGameSign(sign))
                .findFirst();
    }

    /**
     * Permet de de récupérer un {@link GamePlayer} en donnant un {@link Player} en paramètre.
     *
     * @param player associé au {@link GamePlayer}.
     * @return le {@link GamePlayer} associé au player.
     */
    public Optional<GamePlayer> getGamePlayer(final @NotNull Player player) {
        return getGameInstanceList()
                .stream()
                .map(GameInstance::getGamePlayers)
                .map(gamePlayers -> {
                    for (GamePlayer gamePlayer : gamePlayers) {
                        return gamePlayer;
                    }
                    return null;
                })
                .filter(Objects::nonNull)
                .filter(gamePlayer -> gamePlayer.getPlayer().equals(player))
                .findFirst();
    }
}
