package fr.ludovicans.flagwars.game;

import org.bukkit.Location;
import org.checkerframework.checker.index.qual.NonNegative;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public final class GameTeam {

    private final @NotNull List<GamePlayer> gamePlayers;
    private final @NotNull String name;
    private final @NonNegative int maxGamePlayer;

    private final @NotNull List<Location> spawnPoints;
    private final @NotNull List<Location> flagSlots;
    private @NonNegative int flagWonCount = 0;


    public GameTeam(@NotNull final List<GamePlayer> gamePlayers,
                    @NotNull final String name,
                    int maxGamePlayer,
                    @NotNull List<Location> spawnPoints, @NotNull List<Location> flagSlots) throws GameBuildError {
        this.gamePlayers = gamePlayers;
        this.name = name;
        this.maxGamePlayer = maxGamePlayer;
        if (spawnPoints.size() < maxGamePlayer)
            throw new GameBuildError(
                    String.format("Le nombre de spawn pour la team %s doit être d'au moins %d.", name, maxGamePlayer)
            );
        this.spawnPoints = spawnPoints;
        if (flagSlots.size() != 3)
            throw new GameBuildError(
                    String.format("Le nombre de slot à drapeau pour la team %s est de %d au lieu de %d",
                            name,
                            flagSlots.size(),
                            3)
            );
        this.flagSlots = flagSlots;
    }

    public GameTeam(@NotNull final String name,
                    final @NonNegative int maxGamePlayer,
                    @NotNull List<Location> spawnPoints, @NotNull List<Location> flagSlots) throws GameBuildError {
        this(new ArrayList<>(), name, maxGamePlayer, spawnPoints, flagSlots);
    }

    public @NotNull List<GamePlayer> gamePlayers() {
        return gamePlayers;
    }

    public @NotNull String name() {
        return name;
    }

    public @NonNegative int maxGamePlayer() {
        return maxGamePlayer;
    }

    public @NotNull List<Location> getSpawnPoints() {
        return spawnPoints;
    }

    public @NotNull List<Location> getFlagSlots() {
        return flagSlots;
    }

    @NonNegative
    public int getFlagWonCount() {
        return flagWonCount;
    }

    public void setFlagWonCount(@NonNegative final int flagWonCount) {
        this.flagWonCount = flagWonCount;
    }
}
