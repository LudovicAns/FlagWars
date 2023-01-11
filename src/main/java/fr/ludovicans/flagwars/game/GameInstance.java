package fr.ludovicans.flagwars.game;

import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@SuppressWarnings("unused")
public class GameInstance {

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

}
