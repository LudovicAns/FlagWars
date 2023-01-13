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
    private final @NotNull List<GamePlayer> gamePlayerList;
    private final @NotNull List<GameTeam> gameTeams;
    private final @NotNull List<GamePlayer> gamePlayers;
    private final @NotNull Location flagSpawnPoint;
    private final @NotNull List<GamePNJ> gamePNJList;
    private final @NotNull List<GameRessourceSpawner> gameRessourceSpawnerList;
    private final @NotNull List<GameSign> gameSignList;

    public GameInstance(@NotNull final List<GamePlayer> gamePlayerList,
                        @NotNull final List<GameTeam> gameTeams,
                        @NotNull final List<GamePlayer> gamePlayers,
                        @NotNull final Location flagSpawnPoint,
                        @NotNull final List<GamePNJ> gamePNJList,
                        @NotNull final List<GameRessourceSpawner> gameRessourceSpawnerList,
                        @NotNull final List<GameSign> gameSignList) {
        this.gamePlayerList = gamePlayerList;
        this.gameTeams = gameTeams;
        this.gamePlayers = gamePlayers;
        this.flagSpawnPoint = flagSpawnPoint;
        this.gamePNJList = gamePNJList;
        this.gameRessourceSpawnerList = gameRessourceSpawnerList;
        this.gameSignList = gameSignList;
    }

    public enum State {
        LOBBY, START, PREPARATION, FLAGWAR, END, MAP_REGEN
    }

    public @NotNull List<GamePlayer> getGamePlayerList() {
        return gamePlayerList;
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

    public @NotNull List<GamePNJ> getGamePNJList() {
        return gamePNJList;
    }

    public @NotNull List<GameRessourceSpawner> getGameRessourceSpawnerList() {
        return gameRessourceSpawnerList;
    }

    public @NotNull List<GameSign> getGameSignList() {
        return gameSignList;
    }
}
