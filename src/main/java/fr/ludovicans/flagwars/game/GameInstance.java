package fr.ludovicans.flagwars.game;

import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Représentation du jeu <strong>FlagWars</strong>.
 */
@SuppressWarnings("unused")
public final class GameInstance {

    private @NotNull State gameState = State.LOBBY;
    private final @NotNull List<GameTeam> gameTeams;
    private final @NotNull List<GamePlayer> gamePlayers;
    private final @NotNull Location flagSpawnPoint;

    public GameInstance(@NotNull List<GameTeam> gameTeams,
                        @NotNull List<GamePlayer> gamePlayers,
                        @NotNull Location flagSpawnPoint) {
        this.gameTeams = gameTeams;
        this.gamePlayers = gamePlayers;
        this.flagSpawnPoint = flagSpawnPoint;
    }

    public enum State {
        LOBBY, START, PREPARATION, FLAGWAR, END, MAP_REGEN
    }

    public @NotNull State getGameState() {
        return gameState;
    }

    public @NotNull List<GameTeam> getGameTeams() {
        return gameTeams;
    }

    public @NotNull List<GamePlayer> getGamePlayers() {
        return gamePlayers;
    }

    public @NotNull Location getFlagSpawnPoint() {
        return flagSpawnPoint;
    }

    public void setGameState(final @NotNull State gameState) {
        this.gameState = gameState;
    }
}
